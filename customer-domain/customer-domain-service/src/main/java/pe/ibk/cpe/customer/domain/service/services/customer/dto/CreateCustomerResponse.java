package pe.ibk.cpe.customer.domain.service.services.customer.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class CreateCustomerResponse implements Serializable {
    private String customerId;
}
