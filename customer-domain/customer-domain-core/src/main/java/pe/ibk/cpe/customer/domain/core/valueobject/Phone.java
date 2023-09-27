package pe.ibk.cpe.customer.domain.core.valueobject;


import pe.ibk.cpe.dependencies.exception.DomainException;
import pe.ibk.cpe.dependencies.util.RegExpressionUtil;

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
        if (!RegExpressionUtil.match(number, RegExpressionUtil.PHONE))
            throw new DomainException("No phone number : " + number);

    }
}
