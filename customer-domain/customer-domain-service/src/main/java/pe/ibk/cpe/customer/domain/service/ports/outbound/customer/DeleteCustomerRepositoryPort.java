package pe.ibk.cpe.customer.domain.service.ports.outbound.customer;


import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;

public interface DeleteCustomerRepositoryPort {

    boolean apply(CustomerId customerId);

}
