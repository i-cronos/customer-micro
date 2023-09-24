package pe.ibk.cpe.customer.domain.core.valueobject;


import java.math.BigDecimal;

public class Amount {
    private final Currency currency;
    private final BigDecimal value;

    public Amount(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }
}
