package pe.ibk.cpe.customer.domain.core.customer.entity;


import pe.ibk.cpe.customer.domain.core.customer.valueobject.ContactId;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.Email;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.Phone;
import pe.ibk.cpe.dependencies.domain.entity.BaseEntity;

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
}
