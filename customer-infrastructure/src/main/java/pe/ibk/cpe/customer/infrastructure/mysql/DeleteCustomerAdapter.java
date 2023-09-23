package pe.ibk.cpe.customer.infrastructure.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerRepository;
import pe.ibk.cpe.customer.domain.model.entity.Customer;
import pe.ibk.cpe.customer.domain.ports.outbound.DeleteCustomerPort;

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
