package fr.afpa.user.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception ConflictRequestException - Erreur 204 / NO CONTENT
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instancie l'exception RessourceNotFoundException.
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
