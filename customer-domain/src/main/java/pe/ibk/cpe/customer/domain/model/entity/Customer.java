package pe.ibk.cpe.customer.domain.model.entity;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.AggregateRoot;
import pe.ibk.cpe.customer.domain.model.common.Constant;
import pe.ibk.cpe.customer.domain.model.exception.CustomerDomainException;
import pe.ibk.cpe.customer.domain.model.valueobject.BusinessName;
import pe.ibk.cpe.customer.domain.model.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.model.valueobject.Document;
import pe.ibk.cpe.customer.domain.model.valueobject.DocumentType;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
public class Customer extends AggregateRoot<CustomerId> {
    private BusinessName businessName;
    private Document document;
    private Address address;
    private Contact contact;
    private List<Shareholder> shareholders;

    public void validate() {
        validateBusinessName();
        validateDocument();
        validateAddress();
        validateContacts();
        validateShareHolders();
    }

    private void validateBusinessName() {
        if (Objects.isNull(businessName))
            throw new CustomerDomainException("Null business name");

        if (Objects.isNull(businessName.getName()))
            throw new CustomerDomainException("Null business name value");

        if (Objects.isNull(businessName.getSocietyType()))
            throw new CustomerDomainException("Null society type");
    }

    private void validateDocument() {
        if (Objects.isNull(document))
            throw new CustomerDomainException("Null document");

        if (Objects.isNull(document.getDocumentType()))
            throw new CustomerDomainException("Null document type");

        if (Objects.isNull(document.getDocumentNumber()))
            throw new CustomerDomainException("Null document number");

        if (document.getDocumentType().equals(DocumentType.DNI) && document.getDocumentNumber().length() != DocumentType.DNI.getSize())
            throw new CustomerDomainException("No valid document, required size: " + DocumentType.DNI.getSize());

        if (document.getDocumentType().equals(DocumentType.RUC) && document.getDocumentNumber().length() != DocumentType.RUC.getSize())
            throw new CustomerDomainException("No valid document, required size: " + DocumentType.RUC.getSize());

    }

    private void validateAddress() {
        if (Objects.isNull(address))
            throw new CustomerDomainException("Null address");

        address.validate();
    }

    private void validateContacts() {
        if (Objects.isNull(contact))
            throw new CustomerDomainException("Null contact");

        contact.validate();
    }

    private void validateShareHolders() {
        if (Objects.isNull(shareholders) || shareholders.isEmpty())
            throw new CustomerDomainException("No shareholders");

        Integer sum = shareholders.stream()
                .map(s -> s.getPercentage().getValue())
                .reduce(Integer::sum)
                .get();

        if (!Constant.MAX_SHAREHOLDERS_PERCENTAGE.equals(sum))
            throw new CustomerDomainException("Shareholders percentage is not 100%, sum : " + sum);
    }


}
