package fr.afpa.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.user.registration.model.Utilisateur;
import fr.afpa.user.registration.service.SecurityService;
import fr.afpa.user.registration.service.UserService;
import fr.afpa.user.registration.validator.UserValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
public class UserController {
	
	/** The user service. */
	@Autowired
    private UserService userService;

    /** The security service. */
    @Autowired
    private SecurityService securityService;

    /** The user validator. */
    @Autowired
    private UserValidator userValidator;
    
    /**
     * Registration.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Utilisateur());

        return "registration";
    }
    
    /**
     * Registration.
     *
     * @param userForm the user form
     * @param bindingResult the binding result
     * @return the string
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") Utilisateur userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    /**
     * Login.
     *
     * @param model the model
     * @param error the error
     * @param logout the logout
     * @return the string
     */
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    /**
     * Welcome.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
