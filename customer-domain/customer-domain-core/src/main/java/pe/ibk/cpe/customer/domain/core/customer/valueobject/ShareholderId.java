package pe.ibk.cpe.customer.domain.core.customer.valueobject;


import pe.ibk.cpe.dependencies.domain.BaseId;

import java.util.UUID;

public class ShareholderId extends BaseId<UUID> {
    public ShareholderId(UUID value) {
        super(value);
    }
}
