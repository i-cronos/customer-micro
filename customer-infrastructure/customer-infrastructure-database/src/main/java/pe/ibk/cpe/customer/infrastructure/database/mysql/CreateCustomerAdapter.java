package pe.ibk.cpe.customer.infrastructure.database.mysql;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.CreateCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;

@Component
@AllArgsConstructor
public class CreateCustomerAdapter implements CreateCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer apply(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.map(customer);

        CustomerEntity entity = customerRepository.save(customerEntity);

        return customerEntityMapper.map(entity);
    }

}
