package pe.ibk.cpe.customer.domain.core.customer.valueobject;

import pe.ibk.cpe.dependencies.exception.DomainException;

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

    public void validate() {
        if (documentType.equals(DocumentType.DNI) && documentNumber.length() != DocumentType.DNI.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.DNI.getSize());

        if (documentType.equals(DocumentType.RUC) && documentNumber.length() != DocumentType.RUC.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.RUC.getSize());
    }

}
