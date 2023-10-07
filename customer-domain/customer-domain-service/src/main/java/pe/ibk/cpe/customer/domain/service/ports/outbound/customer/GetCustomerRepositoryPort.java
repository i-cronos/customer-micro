package pe.ibk.cpe.customer.domain.service.ports.outbound.customer;


import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;

public interface GetCustomerRepositoryPort {

    Customer apply(CustomerId customerId);
}
