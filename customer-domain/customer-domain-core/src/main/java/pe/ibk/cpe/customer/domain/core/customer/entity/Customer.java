package pe.ibk.cpe.customer.domain.core.customer.entity;


import pe.ibk.cpe.customer.domain.core.common.Constant;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.BusinessName;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.Document;
import pe.ibk.cpe.dependencies.common.exception.BaseException;
import pe.ibk.cpe.dependencies.domain.entity.AggregateRoot;
import pe.ibk.cpe.dependencies.common.exception.DomainException;

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
        validateShareHolders();
    }

    private void validateDocument() {
        document.validate();
    }

    private void validateShareHolders() {
        if (Objects.isNull(shareholders) || shareholders.isEmpty())
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("No shareholders")
                    .userMessage("No valid")
                    .build());

        Integer sum = shareholders.stream()
                .map(s -> s.getPercentage().getValue())
                .reduce(Integer::sum)
                .orElse(0);

        if (!Constant.MAX_SHAREHOLDERS_PERCENTAGE.equals(sum))
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("Shareholders percentage is not 100%, sum : " + sum + "%")
                    .userMessage("Not valid percentage")
                    .build());

        long size = shareholders.stream()
                .filter(Objects::nonNull)
                .count();

        if (size != shareholders.size())
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("Not valid shareholder list")
                    .userMessage("Not valid size")
                    .build());

        shareholders.forEach(Shareholder::validate);

    }

}
