package barcante.condominiummanager.infraestructure.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApplicationResourceAdvice {


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiError handleBusinessException(BusinessException exception) {
        return ApiError.builder()
                .message(exception.getMessage())
                .build();
    }
}
