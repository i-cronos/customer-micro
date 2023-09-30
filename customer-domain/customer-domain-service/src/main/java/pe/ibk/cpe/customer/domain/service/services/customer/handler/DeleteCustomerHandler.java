package pe.ibk.cpe.customer.domain.service.services.customer.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.DeleteCustomerPort;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.DeleteCustomerResponse;

@Component
@AllArgsConstructor
public class DeleteCustomerHandler {
    private final DeleteCustomerPort deleteCustomerPort;

    public DeleteCustomerResponse delete(CustomerId customerId) {
        deleteCustomerPort.apply(customerId);

        return DeleteCustomerResponse.builder()
                .success(true)
                .build();
    }

}
