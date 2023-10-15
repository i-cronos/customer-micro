package pe.ibk.cpe.customer.application.rest.controller.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.domain.service.ports.inbound.customer.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;
import pe.ibk.cpe.dependencies.common.security.SystemUser;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/protected/customer/v1.0")
@AllArgsConstructor
public class CustomerRestController {
    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication();
        log.info("System user id : {}", systemUser.getUserId());
        return ResponseEntity.ok(createCustomerUseCase.apply(createCustomerRequest));
    }
}
