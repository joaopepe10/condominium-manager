package barcante.condominiummanager.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ApiError {

    private String message;
    private String additionalMessage;
    private HttpStatus status;
    private int httpStatusCode;

}
