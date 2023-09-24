package pe.ibk.cpe.customer.domain.service.services;


import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.inbound.DeleteCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.outbound.DeleteCustomerPort;

public class DeleteCustomerService implements DeleteCustomerUseCase {

    private final DeleteCustomerPort deleteCustomerPort;

    public DeleteCustomerService(DeleteCustomerPort deleteCustomerPort) {
        this.deleteCustomerPort = deleteCustomerPort;
    }

    @Override
    public boolean apply(CustomerId customerId) {
        return deleteCustomerPort.apply(customerId);
    }

}
