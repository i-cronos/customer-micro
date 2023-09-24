package pe.ibk.cpe.customer.domain.core.entity;


import pe.ibk.cpe.customer.domain.core.valueobject.AddressId;
import pe.ibk.cpe.dependencies.domain.BaseEntity;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Objects;

public class Address extends BaseEntity<AddressId> {
    private String streetName;
    private String streetNumber;

    public void validate() {
        if (Objects.isNull(streetName))
            throw new DomainException("Null street name");

        if (Objects.isNull(streetNumber))
            throw new DomainException("Null street number");
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
