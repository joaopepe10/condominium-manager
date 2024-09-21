package barcante.condominiummanager.infraestructure.exception;

public class BusinessException extends RuntimeException {

    private static final String message = "Apartamento inexistente";

    public BusinessException() {
        super(message);
    }
}
