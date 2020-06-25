package fr.afpa.user.registration.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.user.registration.model.Role;
import fr.afpa.user.registration.model.Utilisateur;
import fr.afpa.user.registration.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsServiceImpl.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The user DAO. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Load user by username.
	 * On génère un UserDetails qui contient toutes les infos de l'user
	 * Il sert à la création de l'Authentication.
	 *
	 * @param email the email
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// on crée un utilisateur
		Utilisateur user = userRepository.findByUsername(username);

		// on vérifie si l'utilisateur existe, sinon exception
		if (user == null) {
			throw new UsernameNotFoundException("No user found for " + username + ".");
		}

		// on crée un hashset des autorisations accordées
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		// pour chaque role de l'user, on ajoute le role aux autorisations
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
		}

		// on retourne un User (de Spring Security) avec l'email et le mot de passe de
		// l'utilisateur
		// et les autorisations
		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);

	}
}
