package pe.ibk.cpe.customer.application.rest.customer.dto;

import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.domain.core.entity.Address;
import pe.ibk.cpe.customer.domain.core.entity.Contact;
import pe.ibk.cpe.customer.domain.core.entity.Customer;
import pe.ibk.cpe.customer.domain.core.entity.Shareholder;
import pe.ibk.cpe.customer.domain.core.valueobject.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer map(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = new Customer();

        BusinessName businessName = new BusinessName(SocietyType.valueOf(createCustomerRequestDto.getSocietyType()), createCustomerRequestDto.getBusinessName());

        Document document = new Document(DocumentType.valueOf(createCustomerRequestDto.getDocument().getDocumentType()), createCustomerRequestDto.getDocument().getDocumentNumber());

        Address address = new Address();
        address.setStreetName(createCustomerRequestDto.getAddress().getStreetName());
        address.setStreetNumber(createCustomerRequestDto.getAddress().getStreetNumber());

        Contact contact = new Contact();
        contact.setPhone(new Phone(PhoneOperator.valueOf(createCustomerRequestDto.getContact().getPhone().getPhoneOperator()), createCustomerRequestDto.getContact().getPhone().getPhoneNumber()));
        contact.setEmail(new Email(EmailType.valueOf(createCustomerRequestDto.getContact().getEmail().getType()), createCustomerRequestDto.getContact().getEmail().getEmail()));

        List<Shareholder> shareholders = createCustomerRequestDto.getShareholders().stream()
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

    public CreateCustomerResponseDto map(Customer customer) {
        CreateCustomerResponseDto createCustomerResponseDto = new CreateCustomerResponseDto();
        createCustomerResponseDto.setId(customer.getId().getValue().toString());
        return createCustomerResponseDto;
    }
}
