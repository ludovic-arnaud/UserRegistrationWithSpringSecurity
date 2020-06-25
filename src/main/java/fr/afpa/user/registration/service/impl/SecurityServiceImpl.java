package fr.afpa.user.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fr.afpa.user.registration.service.SecurityService;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityServiceImpl.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** The user details service. */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Retourne l'utilisateur connecté
	 *
	 * @return the string
	 */
	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}

	/**
	 * Permet l'autologin après l'enregistrement de l'utilisateur
	 * On crée un token (jeton) à partir de l'user avec ses détails, son mot de passe et ses autorisations.
	 * On passe ensuite ce token manuellement à travers l'authenticationManager.
	 * Si c'est ok, l'user est authentifié.
	 * 
	 *
	 * @param username the username
	 * @param password the password
	 */
	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}

	}

}
