package pe.ibk.cpe.customer.application.rest.controller.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.domain.service.ports.inbound.customer.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerRestController {
    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.ok(createCustomerUseCase.apply(createCustomerRequest));
    }
}