package fr.afpa.user.registration.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.afpa.user.registration.model.Utilisateur;
import fr.afpa.user.registration.repository.RoleRepository;
import fr.afpa.user.registration.repository.UserRepository;
import fr.afpa.user.registration.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/** The b crypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Enregistrement de l'utilisateur avec encodage du mot de passe
	 *
	 * @param user the user
	 */
	@Override
	public void save(Utilisateur user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);

	}

	/**
	 * Retourne l'utilisateur selon son username
	 *
	 * @param username the username
	 * @return the utilisateur
	 */
	@Override
	public Utilisateur findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
