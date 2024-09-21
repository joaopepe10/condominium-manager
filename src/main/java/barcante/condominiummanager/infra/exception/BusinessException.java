package barcante.condominiummanager.infraestructure.exception;

import static barcante.condominiummanager.core.constants.MessageErrorConstants.MESSAGE_ERROR_BUSINESS;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super(MESSAGE_ERROR_BUSINESS);
    }
}
