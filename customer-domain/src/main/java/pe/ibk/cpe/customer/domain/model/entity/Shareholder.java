package pe.ibk.cpe.customer.domain.model.entity;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseEntity;
import pe.ibk.cpe.customer.domain.model.valueobject.DocumentType;
import pe.ibk.cpe.customer.domain.model.valueobject.Percentage;
import pe.ibk.cpe.customer.domain.model.valueobject.ShareholderId;

@Getter
@Setter
public class Shareholder extends BaseEntity<ShareholderId> {
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private Percentage percentage;

}
