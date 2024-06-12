package pl.shelter.exceptions;

import java.util.ResourceBundle;

public class AppException extends Exception{

    public static final String NOT_FOUND = ResourceBundle.getBundle("texts").getString("not.found");
    public static final String ENTITY_EXISTS = ResourceBundle.getBundle("texts").getString("entity.exists");


    public AppException(final String message) {
        super(message);
    }
    public AppException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
