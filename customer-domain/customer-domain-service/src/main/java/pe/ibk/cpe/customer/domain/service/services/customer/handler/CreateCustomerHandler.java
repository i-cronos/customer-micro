package pe.ibk.cpe.customer.domain.service.services.customer.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.CreateCustomerPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.NotifyCustomerCreationPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.VerifyRiskCustomerPort;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.mapper.CreateCustomerMapper;
import pe.ibk.cpe.dependencies.exception.DomainException;

@Component
@AllArgsConstructor
public class CreateCustomerHandler {
    private final CreateCustomerPort createCustomerPort;
    private final VerifyRiskCustomerPort verifyRiskCustomerPort;
    private final NotifyCustomerCreationPort notifyCustomerCreationPort;
    private final CreateCustomerMapper createCustomerMapper;

    public CreateCustomerResponse create(Customer customer) {
        boolean isRisk = verifyRiskCustomerPort.apply(customer.getDocument());

        if (isRisk)
            throw new DomainException("Risk Customer");

        Customer response = createCustomerPort.apply(customer);

        notifyCustomerCreationPort.apply(response);

        return createCustomerMapper.map(response);
    }
}
