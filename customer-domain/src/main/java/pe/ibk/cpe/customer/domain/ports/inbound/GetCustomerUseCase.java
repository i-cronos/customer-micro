package pe.ibk.cpe.customer.domain.ports.inbound;

import pe.ibk.cpe.customer.domain.model.entity.Customer;

public interface GetCustomerUseCase {

    Customer apply(String id);
}
