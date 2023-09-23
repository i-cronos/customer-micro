package pe.ibk.cpe.customer.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.ibk.cpe.customer.domain.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.ports.inbound.DeleteCustomerUseCase;
import pe.ibk.cpe.customer.domain.ports.inbound.GetCustomerUseCase;
import pe.ibk.cpe.customer.domain.ports.outbound.CreateCustomerPort;
import pe.ibk.cpe.customer.domain.ports.outbound.DeleteCustomerPort;
import pe.ibk.cpe.customer.domain.ports.outbound.GetCustomerPort;
import pe.ibk.cpe.customer.domain.service.CreateCustomerService;
import pe.ibk.cpe.customer.domain.service.DeleteCustomerService;
import pe.ibk.cpe.customer.domain.service.GetCustomerService;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CreateCustomerPort createCustomerPort) {
        return new CreateCustomerService(createCustomerPort);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(DeleteCustomerPort deleteCustomerPort) {
        return new DeleteCustomerService(deleteCustomerPort);
    }

    @Bean
    public GetCustomerUseCase getCustomerUseCase(GetCustomerPort getCustomerPort) {
        return new GetCustomerService(getCustomerPort);
    }
}
