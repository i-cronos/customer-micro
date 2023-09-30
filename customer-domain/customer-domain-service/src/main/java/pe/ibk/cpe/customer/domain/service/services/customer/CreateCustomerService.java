package pe.ibk.cpe.customer.domain.service.services.customer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.service.ports.inbound.customer.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;
import pe.ibk.cpe.customer.domain.service.services.customer.handler.CreateCustomerHandler;
import pe.ibk.cpe.customer.domain.service.services.customer.mapper.CreateCustomerMapper;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomerMapper createCustomerMapper;
    private final CreateCustomerHandler createCustomerHandler;

    @Override
    public CreateCustomerResponse apply(CreateCustomerRequest createCustomerRequest) {
        log.info("Create customer : {}", createCustomerRequest.getBusinessName());
        Customer customer = createCustomerMapper.map(createCustomerRequest);

        customer.validate();

        return createCustomerHandler.create(customer);
    }
}
