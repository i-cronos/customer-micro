package pe.ibk.cpe.customer.domain.service.services.customer.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CreateCustomerRequest implements Serializable {
    @NotNull
    private String societyType;
    @NotNull
    private String businessName;
    @NotNull
    private Document document;
    @NotNull
    private Address address;
    @NotNull
    private Contact contact;
    @NotNull
    private List<Shareholder> shareholders;

    @Getter
    @Setter
    public static class Address implements Serializable {
        @NotNull
        private String streetName;
        @NotNull
        private String streetNumber;
    }

    @Getter
    @Setter
    public static class Contact implements Serializable {
        @NotNull
        private Phone phone;
        @NotNull
        private Email email;
    }

    @Getter
    @Setter
    public static class Phone implements Serializable {
        @NotNull
        private String phoneOperator;
        @NotNull
        private String phoneNumber;
    }

    @Getter
    @Setter
    public static class Email implements Serializable {
        @NotNull
        private String type;
        @NotNull
        private String email;
    }

    @Getter
    @Setter
    public static class Shareholder implements Serializable {
        @NotNull
        private String firstName;
        @NotNull
        private String lastName;
        @NotNull
        private Integer percentage;
        @NotNull
        private Document document;
    }

    @Getter
    @Setter
    public static class Document implements Serializable {
        @NotNull
        private String documentType;
        @NotNull
        private String documentNumber;
    }
}
