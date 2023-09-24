package pe.ibk.cpe.customer.application.rest.customer.dto;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Customer;

@Component
public class CustomerMapper {

    public Customer map(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = new Customer();

        return customer;
    }

    public CreateCustomerResponseDto map(Customer customer) {
        CreateCustomerResponseDto createCustomerResponseDto = new CreateCustomerResponseDto();

        return createCustomerResponseDto;
    }
}
