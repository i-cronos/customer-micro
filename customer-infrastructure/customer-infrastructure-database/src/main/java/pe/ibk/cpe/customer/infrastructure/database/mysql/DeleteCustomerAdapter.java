package pe.ibk.cpe.customer.infrastructure.database.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.DeleteCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public DeleteCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public boolean apply(Customer customer) {
        CustomerEntity entity = customerEntityMapper.map(customer);
        try {
            customerRepository.delete(entity);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
