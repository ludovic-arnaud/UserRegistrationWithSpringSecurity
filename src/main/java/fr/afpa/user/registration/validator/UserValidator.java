package fr.afpa.user.registration.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.afpa.user.registration.model.Utilisateur;
import fr.afpa.user.registration.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserValidator. Permet de vérifier et de valider les informations
 * saisies par l'utilisateur lors de l'enregistrement
 */
@Component
public class UserValidator implements Validator {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Ce Validatoir valide les instances de la classe Utilisateur
	 *
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Utilisateur.class.equals(clazz);
	}

	/**
	 * Ce Validator valide la taille de l'email, la taille du mot de passe vérifie
	 * que l'email n'existe pas déjà et que les deux mots de passes saisis soient
	 * bien égaux
	 *
	 * @param target the target
	 * @param errors the errors
	 */
	@Override
	public void validate(Object target, Errors errors) {

		Utilisateur user = (Utilisateur) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.username");
		}
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}

	}

}
