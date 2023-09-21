package pe.ibk.cpe.customer.infrastructure.mysql.repo;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepository {

    public CustomerEntity save(CustomerEntity customerEntity) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setBusinessName(customerEntity.getBusinessName());
        entity.setDocumentType(customerEntity.getDocumentType());
        entity.setDocumentNumber(customerEntity.getDocumentNumber());

        return entity;
    }

    public void delete(CustomerEntity customerEntity) {

    }

    public Optional<CustomerEntity> findById(String id) {
        return Optional.empty();
    }
}
