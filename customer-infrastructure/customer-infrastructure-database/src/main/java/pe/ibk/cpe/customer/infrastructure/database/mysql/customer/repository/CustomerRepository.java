package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.repository;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity.CustomerEntity;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepository {

    public CustomerEntity save(CustomerEntity customerEntity) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setSocietyType(customerEntity.getSocietyType());
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
