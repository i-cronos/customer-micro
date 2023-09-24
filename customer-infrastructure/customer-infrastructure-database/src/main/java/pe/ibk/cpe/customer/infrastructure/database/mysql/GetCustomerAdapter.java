package pe.ibk.cpe.customer.infrastructure.database.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.outbound.GetCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;

import java.util.Optional;

@Component
public class GetCustomerAdapter implements GetCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public GetCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer apply(String id) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(id);

        CustomerEntity entity = optionalEntity.orElseThrow(() -> new RuntimeException("Not found customer with id: " + id));

        return customerEntityMapper.map(entity);
    }

}
