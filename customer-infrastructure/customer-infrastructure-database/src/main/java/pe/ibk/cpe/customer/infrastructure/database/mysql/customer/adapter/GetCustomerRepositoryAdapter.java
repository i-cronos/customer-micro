package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.GetCustomerRepositoryPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.mapper.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GetCustomerRepositoryAdapter implements GetCustomerRepositoryPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer apply(CustomerId customerId) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(customerId.getValue().toString());

        CustomerEntity entity = optionalEntity.orElseThrow(() -> new DomainException("Not found customer, id : " + customerId));

        return customerEntityMapper.map(entity);
    }

}
