package pe.ibk.cpe.customer.domain.core.customer.entity;

import pe.ibk.cpe.customer.domain.core.customer.valueobject.ShareholderId;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.Document;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.Percentage;
import pe.ibk.cpe.dependencies.domain.BaseEntity;

public class Shareholder extends BaseEntity<ShareholderId> {
    private String firstName;
    private String lastName;
    private Document document;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public void setPercentage(Percentage percentage) {
        this.percentage = percentage;
    }

    public void validate() {
        document.validate();
    }
}
