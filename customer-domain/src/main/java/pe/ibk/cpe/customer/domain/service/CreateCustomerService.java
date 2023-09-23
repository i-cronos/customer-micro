package pe.ibk.cpe.customer.domain.service;

import pe.ibk.cpe.customer.domain.model.entity.Customer;
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