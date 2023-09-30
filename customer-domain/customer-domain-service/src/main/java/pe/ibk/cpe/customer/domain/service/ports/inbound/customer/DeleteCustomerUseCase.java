package pe.ibk.cpe.customer.domain.service.ports.inbound.customer;


import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerResponse;

public interface DeleteCustomerUseCase {
    DeleteCustomerResponse apply(DeleteCustomerRequest deleteCustomerRequest);
}
