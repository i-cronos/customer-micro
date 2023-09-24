package pe.ibk.cpe.customer.application.rest.customer.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CreateCustomerRequestDto implements Serializable {
    private String societyType;
    private String businessName;
    private Document document;
    private Address address;
    private Contact contact;
    private List<Shareholder> shareholders;

    @Getter
    @Setter
    public static class Address implements Serializable {
        private String streetName;
        private String streetNumber;
    }

    @Getter
    @Setter
    public static class Contact implements Serializable {
        private Phone phone;
        private Email email;
    }

    @Getter
    @Setter
    public static class Phone implements Serializable {
        private String phoneOperator;
        private String phoneNumber;
    }

    @Getter
    @Setter
    public static class Email implements Serializable {
        private String type;
        private String email;
    }

    @Getter
    @Setter
    public static class Shareholder implements Serializable {
        private String firstName;
        private String lastName;
        private Integer percentage;
        private Document document;
    }

    @Getter
    @Setter
    public static class Document implements Serializable {
        private String documentType;
        private String documentNumber;
    }

}
