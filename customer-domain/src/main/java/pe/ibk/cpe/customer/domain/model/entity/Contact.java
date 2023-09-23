package pe.ibk.cpe.customer.domain.model.entity;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseEntity;
import pe.ibk.cpe.customer.domain.model.exception.CustomerDomainException;
import pe.ibk.cpe.customer.domain.model.valueobject.ContactId;
import pe.ibk.cpe.customer.domain.model.valueobject.Email;
import pe.ibk.cpe.customer.domain.model.valueobject.Phone;

import java.util.Objects;

@Setter
@Getter
public class Contact extends BaseEntity<ContactId> {
    private Phone phone;
    private Email email;

    public void validate() {
        if (Objects.isNull(phone))
            throw new CustomerDomainException("Null phone");

        phone.validate();

        if (Objects.isNull(email))
            throw new CustomerDomainException("Null email");

        email.validate();
    }

}
