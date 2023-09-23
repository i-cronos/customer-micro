package pe.ibk.cpe.customer.domain.ports.outbound;

import pe.ibk.cpe.customer.domain.model.entity.Customer;

public interface GetCustomerPort {

    Customer apply(String id);
}
