package pe.ibk.cpe.customer.domain.core.entity;

import pe.ibk.cpe.customer.domain.core.valueobject.DocumentType;
import pe.ibk.cpe.customer.domain.core.valueobject.Percentage;
import pe.ibk.cpe.customer.domain.core.valueobject.ShareholderId;
import pe.ibk.cpe.dependencies.domain.BaseEntity;

public class Shareholder extends BaseEntity<ShareholderId> {
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private Percentage percentage;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public void setPercentage(Percentage percentage) {
        this.percentage = percentage;
    }
}
