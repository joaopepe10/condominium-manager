package barcante.condominiummanager.infra.exception;

import static barcante.condominiummanager.core.constants.MessageErrorConstants.MESSAGE_ERROR_INVALID_PROPOSAL;

public class InvalidBudgetProposal extends RuntimeException {

    public InvalidBudgetProposal() {
        super(MESSAGE_ERROR_INVALID_PROPOSAL);
    }
}
