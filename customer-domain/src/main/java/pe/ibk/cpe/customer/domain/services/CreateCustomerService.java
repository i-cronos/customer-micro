package pe.ibk.cpe.customer.domain.services;

import pe.ibk.cpe.customer.domain.model.Customer;
import pe.ibk.cpe.customer.domain.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.ports.outbound.CreateCustomerPort;

public class CreateCustomerService implements CreateCustomerUseCase {
    private final CreateCustomerPort createCustomerPort;

    public CreateCustomerService(CreateCustomerPort createCustomerPort) {
        this.createCustomerPort = createCustomerPort;
    }

    @Override
    public Customer apply(Customer customer) {
        return createCustomerPort.apply(customer);
    }
}
