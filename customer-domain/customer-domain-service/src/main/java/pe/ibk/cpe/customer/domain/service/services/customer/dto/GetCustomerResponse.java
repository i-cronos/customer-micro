package pe.ibk.cpe.customer.domain.service.services.customer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCustomerResponse {
    private String customerId;
    private String businessName;
}
