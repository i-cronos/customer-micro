package pe.ibk.cpe.customer.infrastructure.database.mysql;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.DeleteCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntityMapper;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Optional;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public DeleteCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public boolean apply(CustomerId customerId) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(customerId.getValue().toString());

        if (!optionalEntity.isPresent())
            throw new DomainException("No found customer, id : " + customerId.getValue());

        try {
            customerRepository.delete(optionalEntity.get());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
