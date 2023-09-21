package pe.ibk.cpe.customer.domain.services;

import pe.ibk.cpe.customer.domain.model.Customer;
import pe.ibk.cpe.customer.domain.ports.inbound.DeleteCustomerUseCase;
import pe.ibk.cpe.customer.domain.ports.outbound.DeleteCustomerPort;

public class DeleteCustomerService implements DeleteCustomerUseCase {

    private final DeleteCustomerPort deleteCustomerPort;

    public DeleteCustomerService(DeleteCustomerPort deleteCustomerPort) {
        this.deleteCustomerPort = deleteCustomerPort;
    }

    @Override
    public boolean apply(Customer customer) {
        return deleteCustomerPort.apply(customer);
    }

}
