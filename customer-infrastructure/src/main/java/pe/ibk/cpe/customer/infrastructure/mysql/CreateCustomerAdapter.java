package pe.ibk.cpe.customer.infrastructure.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.model.Customer;
import pe.ibk.cpe.customer.domain.ports.outbound.CreateCustomerPort;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.mysql.repo.CustomerRepository;


import java.util.UUID;

@Component
public class CreateCustomerAdapter implements CreateCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public CreateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer apply(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.map(customer);

        CustomerEntity entity = customerRepository.save(customerEntity);

        return customerEntityMapper.map(entity);
    }

}
