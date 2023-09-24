package pe.ibk.cpe.customer.application.rest.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerRequestDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerResponseDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CustomerMapper;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.CreateCustomerUseCase;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerRestController {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> create(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) throws JsonProcessingException {
        System.out.println("BEFORE:\n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(createCustomerRequestDto));
        Customer request = customerMapper.map(createCustomerRequestDto);
        System.out.println("AFTER:\n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));
        Customer response = createCustomerUseCase.apply(request);

        CreateCustomerResponseDto responseDto = customerMapper.map(response);

        return ResponseEntity.ok(responseDto);
    }
}
