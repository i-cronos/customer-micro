package pe.ibk.cpe.customer.domain.core.customer.service;

import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.event.CustomerCreatedEvent;
import pe.ibk.cpe.dependencies.domain.event.DomainEventPublisher;

import java.time.ZonedDateTime;

public class DefaultCustomerDomainService implements CustomerDomainService {

    @Override
    public CustomerCreatedEvent create(Customer customer, DomainEventPublisher<CustomerCreatedEvent> customerCreatedEventDomainEventPublisher) {
        customer.validate();

        return new CustomerCreatedEvent(customer, ZonedDateTime.now(), customerCreatedEventDomainEventPublisher);
    }
}
