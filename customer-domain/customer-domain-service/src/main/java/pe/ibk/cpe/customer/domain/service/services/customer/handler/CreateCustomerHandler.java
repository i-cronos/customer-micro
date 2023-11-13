package pe.ibk.cpe.customer.domain.service.services.customer.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.CreateCustomerRepositoryPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.NotifyCustomerCreationPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.VerifyRiskCustomerPort;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.mapper.CreateCustomerMapper;
import pe.ibk.cpe.dependencies.common.exception.BaseException;
import pe.ibk.cpe.dependencies.common.exception.DomainException;

@Component
@AllArgsConstructor
public class CreateCustomerHandler {
    private final CreateCustomerRepositoryPort createCustomerRepositoryPort;
    private final VerifyRiskCustomerPort verifyRiskCustomerPort;
    private final NotifyCustomerCreationPort notifyCustomerCreationPort;
    private final CreateCustomerMapper createCustomerMapper;

    public CreateCustomerResponse create(Customer customer) {
        boolean isRisky = verifyRiskCustomerPort.apply(customer.getDocument());

        if (isRisky)
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("Risk Customer : " + customer.getBusinessName())
                    .userMessage("Risk Customer")
                    .build());

        Customer response = createCustomerRepositoryPort.apply(customer);

        notifyCustomerCreationPort.apply(response);

        return createCustomerMapper.map(response);
    }
}
