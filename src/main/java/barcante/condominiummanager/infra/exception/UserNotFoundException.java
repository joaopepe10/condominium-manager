package barcante.condominiummanager.infra.exception;

import static barcante.condominiummanager.core.constants.MessageErrorConstants.MESSAGE_ERROR_USER_NOT_FOUND;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super(MESSAGE_ERROR_USER_NOT_FOUND);
    }
}
