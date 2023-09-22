package pe.ibk.cpe.customer.application.rest.dto;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.model.Customer;

@Component
public class CustomerMapper {

    public Customer map(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = new Customer();
        customer.setBusinessName(createCustomerRequestDto.getBusinessName());
        customer.setDocumentType(createCustomerRequestDto.getDocumentType());
        customer.setDocumentNumber(createCustomerRequestDto.getDocumentNumber());

        return customer;
    }

    public CreateCustomerResponseDto map(Customer customer) {
        CreateCustomerResponseDto createCustomerResponseDto = new CreateCustomerResponseDto();
        createCustomerResponseDto.setId(customer.getId());

        return createCustomerResponseDto;
    }
}
