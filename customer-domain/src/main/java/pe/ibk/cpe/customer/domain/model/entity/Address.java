package pe.ibk.cpe.customer.domain.model.entity;

import lombok.Getter;
import lombok.Setter;
import pe.ibk.cpe.customer.domain.model.common.BaseEntity;
import pe.ibk.cpe.customer.domain.model.exception.CustomerDomainException;
import pe.ibk.cpe.customer.domain.model.valueobject.AddressId;

import java.util.Objects;

@Getter
@Setter
public class Address extends BaseEntity<AddressId> {
    private String streetName;
    private String streetNumber;

    public void validate() {
        if (Objects.isNull(streetName))
            throw new CustomerDomainException("Null street name");

        if (Objects.isNull(streetNumber))
            throw new CustomerDomainException("Null street number");

    }
}
