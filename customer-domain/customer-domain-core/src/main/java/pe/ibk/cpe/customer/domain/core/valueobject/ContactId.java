package pe.ibk.cpe.customer.domain.core.valueobject;


import pe.ibk.cpe.dependencies.domain.BaseId;

import java.util.UUID;

public class ContactId extends BaseId<UUID> {
    public ContactId(UUID value) {
        super(value);
    }
}
