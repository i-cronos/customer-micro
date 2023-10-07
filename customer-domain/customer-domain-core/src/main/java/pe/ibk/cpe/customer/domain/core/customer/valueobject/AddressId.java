package pe.ibk.cpe.customer.domain.core.customer.valueobject;


import pe.ibk.cpe.dependencies.domain.BaseId;

import java.util.UUID;

public class AddressId extends BaseId<UUID> {
    public AddressId(UUID value) {
        super(value);
    }
}
