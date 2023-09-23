package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseId;

import java.util.UUID;

@Getter
@Setter
public class ContactId extends BaseId<UUID> {
    public ContactId(UUID value) {
        super(value);
    }
}
