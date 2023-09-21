package pe.ibk.cpe.customer.infrastructure.mysql.repo;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.model.Customer;

@Component
public class CustomerEntityMapper {

    public CustomerEntity map(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBusinessName(customer.getBusinessName());
        customerEntity.setDocumentType(customer.getDocumentType());
        customerEntity.setDocumentNumber(customer.getDocumentNumber());

        return customerEntity;
    }


    public Customer map(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setBusinessName(customerEntity.getBusinessName());
        customer.setDocumentType(customerEntity.getDocumentType());
        customer.setDocumentNumber(customerEntity.getDocumentNumber());

        return customer;
    }
}
