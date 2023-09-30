package pe.ibk.cpe.customer.domain.service.ports.outbound.customer;

import pe.ibk.cpe.customer.domain.core.entity.Customer;

public interface CreateCustomerPort {

    Customer apply(Customer customer);

}
