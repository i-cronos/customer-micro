package pe.ibk.cpe.customer.domain.ports.outbound;

import pe.ibk.cpe.customer.domain.model.entity.Customer;

public interface CreateCustomerPort {

    Customer apply(Customer customer);

}
