package pe.ibk.cpe.customer.domain.core.customer.event;

import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.dependencies.domain.event.DomainEvent;
import pe.ibk.cpe.dependencies.domain.event.DomainEventPublisher;

import java.time.ZonedDateTime;

public class CustomerCreatedEvent implements DomainEvent<Customer> {

    private final Customer customer;
    private final ZonedDateTime createdAt;
    private final DomainEventPublisher<CustomerCreatedEvent> customerCreatedEventDomainEventPublisher;

    public CustomerCreatedEvent(Customer customer,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<CustomerCreatedEvent> customerCreatedEventDomainEventPublisher) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.customerCreatedEventDomainEventPublisher = customerCreatedEventDomainEventPublisher;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
