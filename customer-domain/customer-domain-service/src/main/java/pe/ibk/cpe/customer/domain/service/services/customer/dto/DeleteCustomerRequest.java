package pe.ibk.cpe.customer.domain.service.services.customer.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeleteCustomerRequest {
    @NotNull
    private String customerId;
}
