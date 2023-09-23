package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.ibk.cpe.customer.domain.model.exception.CustomerDomainException;
import pe.ibk.cpe.customer.domain.model.util.RegExpressionUtil;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Email {
    private final EmailType type;
    private final String email;

    public void validate() {
        if (Objects.isNull(type))
            throw new CustomerDomainException("Null email type");

        if (Objects.isNull(email))
            throw new CustomerDomainException("Null email");

        if (!RegExpressionUtil.match(email, RegExpressionUtil.EMAIL))
            throw new CustomerDomainException("No valid email : " + email);

    }


}
