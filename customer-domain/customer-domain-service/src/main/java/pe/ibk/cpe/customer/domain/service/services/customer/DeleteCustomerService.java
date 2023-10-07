package pe.ibk.cpe.customer.domain.service.services.customer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.inbound.customer.DeleteCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.handler.DeleteCustomerHandler;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteCustomerService implements DeleteCustomerUseCase {
    private final DeleteCustomerHandler deleteCustomerHandler;

    @Override
    public DeleteCustomerResponse apply(DeleteCustomerRequest deleteCustomerRequest) {
        log.info("Delete customer id : {}", deleteCustomerRequest.getCustomerId());
        CustomerId customerId = new CustomerId(UUID.fromString(deleteCustomerRequest.getCustomerId()));

        return deleteCustomerHandler.delete(customerId);
    }

}
