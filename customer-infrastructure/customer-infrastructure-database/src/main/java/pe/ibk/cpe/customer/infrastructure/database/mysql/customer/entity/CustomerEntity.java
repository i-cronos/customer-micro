package pe.ibk.cpe.customer.infrastructure.database.mysql.customer.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerEntity {
    private String id;
    private String businessName;
    private String societyType;
    private String documentType;
    private String documentNumber;
    private LocalDateTime creationDate;
}
