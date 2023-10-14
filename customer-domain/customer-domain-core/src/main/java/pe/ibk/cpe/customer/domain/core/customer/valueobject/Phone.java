package pe.ibk.cpe.customer.domain.core.customer.valueobject;


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

}
