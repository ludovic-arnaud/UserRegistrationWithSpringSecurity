package fr.afpa.user.registration.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurityConfig. Spring Security Java Configuration, fichier de
 * configuration Crée le Servlet Filter springSecurityFilterChain responsable de
 * la sécurité (protection des url, validatation des login, mot de passe...)
 * Gère l'authentification à notre place.
 * 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * B crypt password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * La méthode configure définit quelles url sont sécurisées et lesquelles non.
	 * Ici, les pages /registration et /login ne nécessitent pas d'identification
	 * Les autres url qui existent comme /welcome nécessitent elles d'être
	 * identifiées Si un utilisateur non identifié tente d'y accéder, il sera
	 * renvoyé sur /login
	 * 
	 * On peut créer des accès par Role !!!
	 * 
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/registration").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}

	/**
	 * Custom authentication manager. L'AuthenticationManager possède la méthode
	 * authenticate qui permet d'authentifier l'user en utilisant l'objet
	 * Authentication Cet objet contient les informations de l'utilisateur et
	 * notemment ses granted authorities.
	 *
	 * @return the authentication manager
	 * @throws Exception the exception
	 */
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

	/**
	 * On met en place une authentification avec le service userDetailsService +
	 * encodage du mot de passe
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

}
