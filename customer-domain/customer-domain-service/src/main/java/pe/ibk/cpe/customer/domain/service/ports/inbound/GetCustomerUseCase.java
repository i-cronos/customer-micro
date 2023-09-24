package pe.ibk.cpe.customer.domain.service.ports.inbound;


import pe.ibk.cpe.customer.domain.core.entity.Customer;

public interface GetCustomerUseCase {

    Customer apply(String id);

}
