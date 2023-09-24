package pe.ibk.cpe.customer.infrastructure.database.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.GetCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.exception.DomainException;

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
    public Customer apply(CustomerId customerId) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(customerId.getValue().toString());

        CustomerEntity entity = optionalEntity.orElseThrow(() -> new DomainException("Not found customer, id : " + customerId));

        return customerEntityMapper.map(entity);
    }

}
