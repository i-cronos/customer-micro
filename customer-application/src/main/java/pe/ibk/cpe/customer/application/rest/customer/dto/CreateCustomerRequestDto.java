package pe.ibk.cpe.customer.application.rest.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequestDto {
    private String businessName;
    private String documentType;
    private String documentNumber;
}
