package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.CustomerId;
import pe.ibk.cpe.customer.domain.service.ports.outbound.customer.DeleteCustomerRepositoryPort;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity.CustomerEntity;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.repository.CustomerRepository;
import pe.ibk.cpe.dependencies.common.exception.BaseException;
import pe.ibk.cpe.dependencies.common.exception.DomainException;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DeleteCustomerRepositoryAdapter implements DeleteCustomerRepositoryPort {

    private final CustomerRepository customerRepository;

    @Override
    public boolean apply(CustomerId customerId) {
        Optional<CustomerEntity> optionalEntity = customerRepository.findById(customerId.getValue().toString());

        if (!optionalEntity.isPresent())
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("No found customer, id : " + customerId.getValue())
                    .userMessage("Not found customer")
                    .build());

        try {
            customerRepository.delete(optionalEntity.get());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
