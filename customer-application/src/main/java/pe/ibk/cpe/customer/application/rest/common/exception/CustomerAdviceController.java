package pe.ibk.cpe.customer.application.rest.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomerAdviceController {

    @ExceptionHandler({DomainException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handle(DomainException exception, WebRequest webRequest) {
        return Error.builder()
                .current(LocalDateTime.now())
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .build();

    }

    @Getter
    @Builder
    public static class Error {
        private LocalDateTime current;
        private String message;
        private String status;
    }
}
