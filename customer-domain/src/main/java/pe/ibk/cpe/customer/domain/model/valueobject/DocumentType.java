package pe.ibk.cpe.customer.domain.model.valueobject;

import lombok.Getter;

@Getter
public enum DocumentType {
    RUC(11),
    DNI(8);

    private final Integer size;

    DocumentType(Integer size) {
        this.size = size;
    }
}
