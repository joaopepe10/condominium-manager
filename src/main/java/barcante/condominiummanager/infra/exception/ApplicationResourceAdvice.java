package barcante.condominiummanager.infra.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static barcante.condominiummanager.core.constants.MessageErrorConstants.MESSAGE_ERROR_DEFAULT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiError handleException(Exception exception) {
        return ApiError.builder()
                .message(exception.getMessage())
                .additionalMessage(MESSAGE_ERROR_DEFAULT)
                .status(BAD_REQUEST)
                .httpStatusCode(BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiError handleBusinessException(BusinessException exception) {
        return ApiError.builder()
                .message(exception.getMessage())
                .status(NOT_FOUND)
                .httpStatusCode(NOT_FOUND.value())
                .build();
    }


}
