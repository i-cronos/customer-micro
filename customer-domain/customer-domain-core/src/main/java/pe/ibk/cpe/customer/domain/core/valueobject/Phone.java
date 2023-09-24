package pe.ibk.cpe.customer.domain.core.valueobject;


import pe.ibk.cpe.dependencies.exception.DomainException;
import pe.ibk.cpe.dependencies.util.RegExpressionUtil;

import java.util.Objects;

public class Phone {
    private final PhoneOperator phoneOperator;
    private final String number;

    public Phone(PhoneOperator phoneOperator, String number) {
        this.phoneOperator = phoneOperator;
        this.number = number;
    }

    public PhoneOperator getPhoneOperator() {
        return phoneOperator;
    }

    public String getNumber() {
        return number;
    }

    public void validate() {
        if (Objects.isNull(phoneOperator))
            throw new DomainException("Null phone operator");

        if (Objects.isNull(number))
            throw new DomainException("Null phone number");

        if (!RegExpressionUtil.match(number, RegExpressionUtil.PHONE))
            throw new DomainException("No phone number : " + number);

    }
}
