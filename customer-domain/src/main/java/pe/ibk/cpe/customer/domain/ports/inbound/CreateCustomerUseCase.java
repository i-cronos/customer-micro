package pe.ibk.cpe.customer.domain.ports.inbound;

import pe.ibk.cpe.customer.domain.model.Customer;

public interface CreateCustomerUseCase {

    Customer apply(Customer customer);
}
