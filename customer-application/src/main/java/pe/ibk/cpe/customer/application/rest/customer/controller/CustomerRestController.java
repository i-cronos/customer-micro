package pe.ibk.cpe.customer.application.rest.customer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerRequestDto;
import pe.ibk.cpe.customer.application.rest.customer.dto.CreateCustomerResponseDto;
import pe.ibk.cpe.customer.application.rest.customer.facade.CreateCustomerFacade;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerRestController {
    private final CreateCustomerFacade createCustomerFacade;

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> create(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        return ResponseEntity.ok(createCustomerFacade.create(createCustomerRequestDto));
    }
}
