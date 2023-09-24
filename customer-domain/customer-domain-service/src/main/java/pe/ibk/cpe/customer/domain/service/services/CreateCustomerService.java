package pe.ibk.cpe.customer.domain.service.services;


import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.outbound.CreateCustomerPort;

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
