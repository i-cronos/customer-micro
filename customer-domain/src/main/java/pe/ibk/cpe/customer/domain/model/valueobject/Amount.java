package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Amount {
    private final Currency currency;
    private final BigDecimal value;

    public Amount(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }
}
