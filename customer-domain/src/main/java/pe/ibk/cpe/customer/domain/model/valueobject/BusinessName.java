package pe.ibk.cpe.customer.domain.model.valueobject;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessName {
    private final SocietyType societyType;
    private final String name;
}
