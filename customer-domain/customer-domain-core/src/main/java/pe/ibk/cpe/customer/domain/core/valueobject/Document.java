package pe.ibk.cpe.customer.domain.core.valueobject;

public class Document {
    private final DocumentType documentType;
    private final String documentNumber;

    public Document(DocumentType documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
