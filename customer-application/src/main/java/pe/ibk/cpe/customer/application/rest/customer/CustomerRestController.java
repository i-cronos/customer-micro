package pe.ibk.cpe.customer.application.rest.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerRequestDto;
import pe.ibk.cpe.customer.domain.model.entity.Customer;
import pe.ibk.cpe.customer.domain.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerResponseDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CustomerMapper;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerRestController {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> create(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        Customer request = customerMapper.map(createCustomerRequestDto);
        Customer response = createCustomerUseCase.apply(request);

        CreateCustomerResponseDto responseDto = customerMapper.map(response);

        return ResponseEntity.ok(responseDto);
    }
}
