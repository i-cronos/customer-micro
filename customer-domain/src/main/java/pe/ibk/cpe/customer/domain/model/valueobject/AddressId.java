package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseId;

import java.util.UUID;

@Getter
@Setter
public class AddressId extends BaseId<UUID> {
    public AddressId(UUID value) {
        super(value);
    }
}
