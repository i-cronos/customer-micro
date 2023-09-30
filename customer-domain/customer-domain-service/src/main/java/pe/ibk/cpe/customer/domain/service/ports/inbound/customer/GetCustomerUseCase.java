package pe.ibk.cpe.customer.domain.service.ports.inbound.customer;


import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerResponse;

public interface GetCustomerUseCase {

    GetCustomerResponse apply(GetCustomerRequest getCustomerRequest);

}
