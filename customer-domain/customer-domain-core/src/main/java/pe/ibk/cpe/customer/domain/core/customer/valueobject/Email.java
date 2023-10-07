package pe.ibk.cpe.customer.domain.core.customer.valueobject;

import pe.ibk.cpe.dependencies.exception.DomainException;
import pe.ibk.cpe.dependencies.util.RegExpressionUtil;

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

    public void validate() {
        if (!RegExpressionUtil.match(email, RegExpressionUtil.EMAIL))
            throw new DomainException("No valid email : " + email);

    }


}
