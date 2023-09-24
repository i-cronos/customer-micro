package pe.ibk.cpe.customer.domain.service.services;


import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.GetCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.outbound.GetCustomerPort;

public class GetCustomerService implements GetCustomerUseCase {
    private final GetCustomerPort getCustomerPort;

    public GetCustomerService(GetCustomerPort getCustomerPort) {
        this.getCustomerPort = getCustomerPort;
    }

    @Override
    public Customer apply(String id) {
        return getCustomerPort.apply(id);
    }

}
