package fr.afpa.user.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception BadRequestException - Erreur 400 / BAD REQUEST
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instancie l'exception BadRequestException.
     *
     * @param message
     */
    public BadRequestException(String message) {
        super(message);
    }
}
