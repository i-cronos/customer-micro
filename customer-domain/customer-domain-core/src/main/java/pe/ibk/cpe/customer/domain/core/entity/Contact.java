package pe.ibk.cpe.customer.domain.core.entity;


import pe.ibk.cpe.customer.domain.core.valueobject.ContactId;
import pe.ibk.cpe.customer.domain.core.valueobject.Email;
import pe.ibk.cpe.customer.domain.core.valueobject.Phone;
import pe.ibk.cpe.dependencies.domain.BaseEntity;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Objects;

public class Contact extends BaseEntity<ContactId> {
    private Phone phone;
    private Email email;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void validate() {
        if (Objects.isNull(phone))
            throw new DomainException("Null phone");

        phone.validate();

        if (Objects.isNull(email))
            throw new DomainException("Null email");

        email.validate();
    }

}
