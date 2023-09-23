package pe.ibk.cpe.customer.domain.service;

import pe.ibk.cpe.customer.domain.model.entity.Customer;
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
