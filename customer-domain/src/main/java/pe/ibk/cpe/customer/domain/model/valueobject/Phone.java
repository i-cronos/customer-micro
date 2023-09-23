package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.ibk.cpe.customer.domain.model.exception.CustomerDomainException;
import pe.ibk.cpe.customer.domain.model.util.RegExpressionUtil;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Phone {
    private final PhoneOperator phoneOperator;
    private final String number;

    public void validate() {
        if (Objects.isNull(phoneOperator))
            throw new CustomerDomainException("Null phone operator");

        if (Objects.isNull(number))
            throw new CustomerDomainException("Null phone number");

        if (!RegExpressionUtil.match(number, RegExpressionUtil.PHONE))
            throw new CustomerDomainException("No phone number : " + number);

    }
}
