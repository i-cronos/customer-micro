package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.adapter;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.CreateCustomerRepositoryPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.mapper.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.repository.CustomerRepository;

@Component
@AllArgsConstructor
public class CreateCustomerRepositoryAdapter implements CreateCustomerRepositoryPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer apply(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.map(customer);

        CustomerEntity entity = customerRepository.save(customerEntity);

        return customerEntityMapper.map(entity);
    }

}
