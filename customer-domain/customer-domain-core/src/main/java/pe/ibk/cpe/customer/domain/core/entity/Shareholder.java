package pe.ibk.cpe.customer.domain.core.entity;

import pe.ibk.cpe.customer.domain.core.valueobject.Document;
import pe.ibk.cpe.customer.domain.core.valueobject.Percentage;
import pe.ibk.cpe.customer.domain.core.valueobject.ShareholderId;
import pe.ibk.cpe.dependencies.domain.BaseEntity;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Objects;

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
        if (Objects.isNull(firstName))
            throw new DomainException("Shareholder first name is null");

        if (Objects.isNull(lastName))
            throw new DomainException("Shareholder last name is null");

        if (Objects.isNull(document))
            throw new DomainException("Shareholder document is null");

        document.validate();
    }
}
