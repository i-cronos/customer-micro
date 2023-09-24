package pe.ibk.cpe.customer.domain.service.ports.outbound;

import pe.ibk.cpe.customer.domain.core.entity.Customer;

public interface NotifyCustomerCreationPort {

    boolean apply(Customer customer);

}
