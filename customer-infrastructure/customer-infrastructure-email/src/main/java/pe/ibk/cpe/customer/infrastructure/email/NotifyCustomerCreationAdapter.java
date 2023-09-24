package pe.ibk.cpe.customer.infrastructure.email;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.NotifyCustomerCreationPort;

@Component
public class NotifyCustomerCreationAdapter implements NotifyCustomerCreationPort {

    @Override
    public boolean apply(Customer customer) {
        return true;
    }

}
