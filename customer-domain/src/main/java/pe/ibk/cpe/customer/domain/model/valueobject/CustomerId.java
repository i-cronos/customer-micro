package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseId;

import java.util.UUID;

@Getter
@Setter
public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }
}
