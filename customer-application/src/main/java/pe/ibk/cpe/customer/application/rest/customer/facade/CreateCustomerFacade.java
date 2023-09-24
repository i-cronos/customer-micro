package pe.ibk.cpe.customer.application.rest.customer.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerRequestDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerResponseDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CustomerMapper;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.CreateCustomerUseCase;

@Component
@AllArgsConstructor
public class CreateCustomerFacade {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerMapper customerMapper;

    public CreateCustomerResponseDto create(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer request = customerMapper.map(createCustomerRequestDto);

        request.validate();

        Customer response = createCustomerUseCase.apply(request);

        return customerMapper.map(response);
    }
}
