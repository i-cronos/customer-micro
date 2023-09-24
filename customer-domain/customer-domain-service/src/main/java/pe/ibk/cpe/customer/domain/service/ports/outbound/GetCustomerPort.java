package pe.ibk.cpe.customer.domain.service.ports.outbound;


import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;

public interface GetCustomerPort {

    Customer apply(CustomerId customerId);
}
