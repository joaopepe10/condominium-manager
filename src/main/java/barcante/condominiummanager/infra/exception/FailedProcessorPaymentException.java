package barcante.condominiummanager.infra.exception;

import static barcante.condominiummanager.core.constants.MessageErrorConstants.MESSAGE_ERROR_PROCESS_PAYMENT;

public class FailedProcessorPaymentException extends RuntimeException{

    public FailedProcessorPaymentException() {
        super(MESSAGE_ERROR_PROCESS_PAYMENT);
    }
}
