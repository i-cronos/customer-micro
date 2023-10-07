package pe.ibk.cpe.customer.domain.core.customer.valueobject;


public enum DocumentType {
    RUC(11),
    DNI(8);

    private final Integer size;

    DocumentType(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
