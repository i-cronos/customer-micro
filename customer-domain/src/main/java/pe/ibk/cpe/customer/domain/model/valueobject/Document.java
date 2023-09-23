package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Document {
    private final DocumentType documentType;
    private final String documentNumber;
}
