package pe.ibk.cpe.customer.domain.service.services.customer.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.DeleteCustomerRepositoryPort;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerResponse;

@Component
@AllArgsConstructor
public class DeleteCustomerHandler {
    private final DeleteCustomerRepositoryPort deleteCustomerRepositoryPort;

    public DeleteCustomerResponse delete(CustomerId customerId) {
        deleteCustomerRepositoryPort.apply(customerId);

        return DeleteCustomerResponse.builder()
                .success(true)
                .build();
    }

}
