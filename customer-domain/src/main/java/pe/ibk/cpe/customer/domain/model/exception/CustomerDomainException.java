package pe.ibk.cpe.customer.domain.model.exception;

public class CustomerDomainException extends RuntimeException {

    public CustomerDomainException(String message) {
        super(message);
    }

    public CustomerDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
