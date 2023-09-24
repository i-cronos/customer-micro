package pe.ibk.cpe.customer.domain.core.entity;


import pe.ibk.cpe.customer.domain.core.common.Constant;
import pe.ibk.cpe.customer.domain.core.valueobject.BusinessName;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.core.valueobject.Document;
import pe.ibk.cpe.customer.domain.core.valueobject.DocumentType;
import pe.ibk.cpe.dependencies.domain.AggregateRoot;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.List;
import java.util.Objects;


public class Customer extends AggregateRoot<CustomerId> {
    private BusinessName businessName;
    private Document document;
    private Address address;
    private Contact contact;
    private List<Shareholder> shareholders;

    public BusinessName getBusinessName() {
        return businessName;
    }

    public void setBusinessName(BusinessName businessName) {
        this.businessName = businessName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Shareholder> getShareholders() {
        return shareholders;
    }

    public void setShareholders(List<Shareholder> shareholders) {
        this.shareholders = shareholders;
    }

    public void validate() {
        validateBusinessName();
        validateDocument();
        validateAddress();
        validateContacts();
        validateShareHolders();
    }

    private void validateBusinessName() {
        if (Objects.isNull(businessName))
            throw new DomainException("Null business name");

        if (Objects.isNull(businessName.getName()))
            throw new DomainException("Null business name value");

        if (Objects.isNull(businessName.getSocietyType()))
            throw new DomainException("Null society type");
    }

    private void validateDocument() {
        if (Objects.isNull(document))
            throw new DomainException("Null document");

        if (Objects.isNull(document.getDocumentType()))
            throw new DomainException("Null document type");

        if (Objects.isNull(document.getDocumentNumber()))
            throw new DomainException("Null document number");

        if (document.getDocumentType().equals(DocumentType.DNI) && document.getDocumentNumber().length() != DocumentType.DNI.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.DNI.getSize());

        if (document.getDocumentType().equals(DocumentType.RUC) && document.getDocumentNumber().length() != DocumentType.RUC.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.RUC.getSize());

    }

    private void validateAddress() {
        if (Objects.isNull(address))
            throw new DomainException("Null address");

        address.validate();
    }

    private void validateContacts() {
        if (Objects.isNull(contact))
            throw new DomainException("Null contact");

        contact.validate();
    }

    private void validateShareHolders() {
        if (Objects.isNull(shareholders) || shareholders.isEmpty())
            throw new DomainException("No shareholders");

        Integer sum = shareholders.stream()
                .map(s -> s.getPercentage().getValue())
                .reduce(Integer::sum)
                .get();

        if (!Constant.MAX_SHAREHOLDERS_PERCENTAGE.equals(sum))
            throw new DomainException("Shareholders percentage is not 100%, sum : " + sum);
    }

}
