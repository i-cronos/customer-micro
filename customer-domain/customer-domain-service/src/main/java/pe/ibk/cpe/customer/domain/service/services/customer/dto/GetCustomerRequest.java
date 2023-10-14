package pe.ibk.cpe.customer.domain.service.services.customer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCustomerRequest {
    @NotNull
    private String customerId;
}
