package pe.ibk.cpe.customer.domain.core.customer.service;

import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.event.CustomerCreatedEvent;
import pe.ibk.cpe.dependencies.domain.event.DomainEventPublisher;

public interface CustomerDomainService {

    CustomerCreatedEvent create(Customer customer, DomainEventPublisher<CustomerCreatedEvent> customerDomainEventPublisher);

}
