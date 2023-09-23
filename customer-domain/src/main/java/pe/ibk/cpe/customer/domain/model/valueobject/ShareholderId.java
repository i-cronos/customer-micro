package pe.ibk.cpe.customer.domain.model.valueobject;

import pe.ibk.cpe.customer.domain.model.common.BaseId;

import java.util.UUID;

public class ShareholderId extends BaseId<UUID> {
    public ShareholderId(UUID value) {
        super(value);
    }
}
