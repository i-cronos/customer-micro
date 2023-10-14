package pe.ibk.cpe.customer.domain.core.customer.valueobject;


import pe.ibk.cpe.dependencies.domain.valuobject.BaseId;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }

}
