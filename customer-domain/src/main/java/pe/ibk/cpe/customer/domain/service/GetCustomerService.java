package pe.ibk.cpe.customer.domain.service;

import pe.ibk.cpe.customer.domain.model.entity.Customer;
import pe.ibk.cpe.customer.domain.ports.outbound.GetCustomerPort;
import pe.ibk.cpe.customer.domain.ports.inbound.GetCustomerUseCase;

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
