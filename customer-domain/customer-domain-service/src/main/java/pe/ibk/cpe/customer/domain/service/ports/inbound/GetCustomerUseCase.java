package pe.ibk.cpe.customer.domain.service.ports.inbound;


import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;

public interface GetCustomerUseCase {

    Customer apply(CustomerId customerId);

}
