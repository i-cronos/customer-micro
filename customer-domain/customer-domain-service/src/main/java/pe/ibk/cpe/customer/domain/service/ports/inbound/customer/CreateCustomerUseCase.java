package pe.ibk.cpe.customer.domain.service.ports.inbound.customer;


import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;

public interface CreateCustomerUseCase {

    CreateCustomerResponse apply(CreateCustomerRequest createCustomerRequest);
}
