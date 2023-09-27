package pe.ibk.cpe.customer.domain.core.entity;


import pe.ibk.cpe.customer.domain.core.common.Constant;
import pe.ibk.cpe.customer.domain.core.valueobject.BusinessName;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.core.valueobject.Document;
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
        validateDocument();
        validateContacts();
        validateShareHolders();
    }

    private void validateDocument() {
        document.validate();
    }

    private void validateContacts() {
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
            throw new DomainException("Shareholders percentage is not 100%, sum : " + sum + "%");

        long size = shareholders.stream()
                .filter(Objects::nonNull)
                .count();

        if (size != shareholders.size())
            throw new DomainException("Not valid shareholder list");

        shareholders.forEach(Shareholder::validate);

    }

}
