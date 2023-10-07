package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.mapper;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.*;
import pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity.CustomerEntity;

import java.util.UUID;

@Component
public class CustomerEntityMapper {

    public CustomerEntity map(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setSocietyType(customer.getBusinessName().getSocietyType().name());
        customerEntity.setBusinessName(customer.getBusinessName().getName());
        customerEntity.setDocumentType(customer.getDocument().getDocumentType().name());
        customerEntity.setDocumentNumber(customer.getDocument().getDocumentNumber());

        return customerEntity;
    }


    public Customer map(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(new CustomerId(UUID.fromString(customerEntity.getId())));
        customer.setBusinessName(new BusinessName(SocietyType.valueOf(customerEntity.getSocietyType()), customerEntity.getBusinessName()));
        customer.setDocument(new Document(DocumentType.valueOf(customerEntity.getDocumentType()), customerEntity.getDocumentNumber()));

        return customer;
    }
}
