package pe.ibk.cpe.customer.domain.service.services.customer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.inbound.customer.GetCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.GetCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.handler.GetCustomerHandler;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class GetCustomerService implements GetCustomerUseCase {
    private final GetCustomerHandler getCustomerHandler;

    @Override
    public GetCustomerResponse apply(GetCustomerRequest getCustomerRequest) {
        log.info("Get customer id : {}", getCustomerRequest.getCustomerId());
        CustomerId customerId = new CustomerId(UUID.fromString(getCustomerRequest.getCustomerId()));

        return getCustomerHandler.get(customerId);
    }

}
