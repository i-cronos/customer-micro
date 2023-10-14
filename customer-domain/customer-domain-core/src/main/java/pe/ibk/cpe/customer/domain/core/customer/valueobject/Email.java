package pe.ibk.cpe.customer.domain.core.customer.valueobject;


public class Email {
    private final EmailType type;
    private final String email;

    public Email(EmailType type, String email) {
        this.type = type;
        this.email = email;
    }

    public EmailType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

}
