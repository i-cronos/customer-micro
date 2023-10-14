package pe.ibk.cpe.customer.domain.core.customer.valueobject;


import pe.ibk.cpe.dependencies.domain.valuobject.BaseId;

import java.util.UUID;

public class ContactId extends BaseId<UUID> {
    public ContactId(UUID value) {
        super(value);
    }
}
