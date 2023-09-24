package pe.ibk.cpe.customer.domain.service.services;


import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.outbound.CreateCustomerPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.NotifyCustomerCreationPort;
import pe.ibk.cpe.customer.domain.service.ports.outbound.VerifyRiskCustomerPort;
import pe.ibk.cpe.dependencies.exception.DomainException;

public class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomerPort createCustomerPort;
    private final VerifyRiskCustomerPort verifyRiskCustomerPort;
    private final NotifyCustomerCreationPort notifyCustomerCreationPort;

    public CreateCustomerService(CreateCustomerPort createCustomerPort,
                                 VerifyRiskCustomerPort verifyRiskCustomerPort,
                                 NotifyCustomerCreationPort notifyCustomerCreationPort) {
        this.createCustomerPort = createCustomerPort;
        this.verifyRiskCustomerPort = verifyRiskCustomerPort;
        this.notifyCustomerCreationPort = notifyCustomerCreationPort;
    }

    @Override
    public Customer apply(Customer customer) {
        boolean isRisk = verifyRiskCustomerPort.apply(customer.getDocument());

        if (isRisk)
            throw new DomainException("Risk Customer");

        Customer response = createCustomerPort.apply(customer);

        notifyCustomerCreationPort.apply(customer);

        return response;
    }
}
