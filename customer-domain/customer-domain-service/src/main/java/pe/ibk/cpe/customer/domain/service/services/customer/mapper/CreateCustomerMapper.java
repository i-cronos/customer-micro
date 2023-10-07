package pe.ibk.cpe.customer.domain.service.services.customer.mapper;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.customer.entity.Address;
import pe.ibk.cpe.customer.domain.core.customer.entity.Contact;
import pe.ibk.cpe.customer.domain.core.customer.entity.Customer;
import pe.ibk.cpe.customer.domain.core.customer.entity.Shareholder;
import pe.ibk.cpe.customer.domain.core.customer.valueobject.*;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerRequest;
import pe.ibk.cpe.customer.domain.service.services.customer.dto.CreateCustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateCustomerMapper {
    public Customer map(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();

        BusinessName businessName = new BusinessName(SocietyType.valueOf(createCustomerRequest.getSocietyType()), createCustomerRequest.getBusinessName());

        Document document = new Document(DocumentType.valueOf(createCustomerRequest.getDocument().getDocumentType()), createCustomerRequest.getDocument().getDocumentNumber());

        Address address = new Address();
        address.setStreetName(createCustomerRequest.getAddress().getStreetName());
        address.setStreetNumber(createCustomerRequest.getAddress().getStreetNumber());

        Contact contact = new Contact();
        contact.setPhone(new Phone(PhoneOperator.valueOf(createCustomerRequest.getContact().getPhone().getPhoneOperator()), createCustomerRequest.getContact().getPhone().getPhoneNumber()));
        contact.setEmail(new Email(EmailType.valueOf(createCustomerRequest.getContact().getEmail().getType()), createCustomerRequest.getContact().getEmail().getEmail()));

        List<Shareholder> shareholders = createCustomerRequest.getShareholders().stream()
                .map(d -> {
                    Shareholder shareholder = new Shareholder();
                    shareholder.setFirstName(d.getFirstName());
                    shareholder.setLastName(d.getLastName());
                    shareholder.setDocument(new Document(DocumentType.valueOf(d.getDocument().getDocumentType()), d.getDocument().getDocumentNumber()));
                    shareholder.setPercentage(new Percentage(d.getPercentage()));
                    return shareholder;
                }).collect(Collectors.toList());

        customer.setBusinessName(businessName);
        customer.setDocument(document);
        customer.setAddress(address);
        customer.setContact(contact);
        customer.setShareholders(shareholders);

        return customer;
    }

    public CreateCustomerResponse map(Customer customer) {
        return CreateCustomerResponse.builder()
                .customerId(customer.getId().getValue().toString())
                .build();
    }
}
