package pe.ibk.cpe.customer.domain.service.services.customer.mapper;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerResponse;

@Component
public class GetCustomerMapper {

    public GetCustomerResponse map(Customer customer) {
        return GetCustomerResponse.builder()
                .customerId(customer.getId().getValue().toString())
                .businessName(customer.getBusinessName().getName())
                .build();
    }
}
