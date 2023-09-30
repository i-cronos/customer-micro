package pe.ibk.cpe.customer.infrastructure.database.mysql;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.DeleteCustomerPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DeleteCustomerAdapter implements DeleteCustomerPort {

    private final CustomerRepository customerRepository;

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
