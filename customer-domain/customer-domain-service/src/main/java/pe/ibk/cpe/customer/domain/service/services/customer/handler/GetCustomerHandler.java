package pe.ibk.cpe.customer.domain.service.services.customer.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.GetCustomerPort;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.mapper.GetCustomerMapper;

@Component
@AllArgsConstructor
public class GetCustomerHandler {
    private final GetCustomerPort getCustomerPort;
    private final GetCustomerMapper getCustomerMapper;

    public GetCustomerResponse get(CustomerId customerId) {
        Customer customer = getCustomerPort.apply(customerId);

        return getCustomerMapper.map(customer);
    }
}
