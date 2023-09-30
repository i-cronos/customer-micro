package pe.ibk.cpe.customer.infrastructure.database.mysql;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.GetCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetCustomerAdapter implements GetCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer apply(CustomerId customerId) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(customerId.getValue().toString());

        CustomerEntity entity = optionalEntity.orElseThrow(() -> new DomainException("Not found customer, id : " + customerId));

        return customerEntityMapper.map(entity);
    }

}
