package pe.ibk.cpe.customer.domain.service.ports.inbound;


import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;

public interface DeleteCustomerUseCase {
    boolean apply(CustomerId customerId);
}
