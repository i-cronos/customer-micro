package pe.ibk.cpe.customer.domain.core.valueobject;


import pe.ibk.cpe.dependencies.domain.BaseId;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }

}
