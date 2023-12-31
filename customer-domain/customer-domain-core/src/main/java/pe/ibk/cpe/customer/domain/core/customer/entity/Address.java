package pe.ibk.cpe.customer.domain.core.customer.entity;


import pe.ibk.cpe.customer.domain.core.customer.valueobject.AddressId;
import pe.ibk.cpe.dependencies.domain.entity.BaseEntity;

public class Address extends BaseEntity<AddressId> {
    private String streetName;
    private String streetNumber;

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
