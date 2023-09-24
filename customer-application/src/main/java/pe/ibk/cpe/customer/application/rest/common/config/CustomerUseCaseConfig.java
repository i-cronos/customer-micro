package pe.ibk.cpe.customer.application.rest.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.ibk.cpe.customer.domain.service.ports.inbound.CreateCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.inbound.DeleteCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.inbound.GetCustomerUseCase;
import pe.ibk.cpe.customer.domain.service.ports.outbound.*;
import pe.ibk.cpe.customer.domain.service.services.CreateCustomerService;
import pe.ibk.cpe.customer.domain.service.services.DeleteCustomerService;
import pe.ibk.cpe.customer.domain.service.services.GetCustomerService;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CreateCustomerPort createCustomerPort,
                                                       VerifyRiskCustomerPort verifyRiskCustomerPort,
                                                       NotifyCustomerCreationPort notifyCustomerCreationPort) {
        return new CreateCustomerService(createCustomerPort, verifyRiskCustomerPort, notifyCustomerCreationPort);
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
