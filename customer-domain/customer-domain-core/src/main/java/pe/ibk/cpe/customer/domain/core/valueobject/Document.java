package pe.ibk.cpe.customer.domain.core.valueobject;

import pe.ibk.cpe.dependencies.exception.DomainException;

import java.util.Objects;

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
        if (Objects.isNull(documentType))
            throw new DomainException("Null document type");

        if (Objects.isNull(documentNumber))
            throw new DomainException("Null document number");

        if (documentType.equals(DocumentType.DNI) && documentNumber.length() != DocumentType.DNI.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.DNI.getSize());

        if (documentType.equals(DocumentType.RUC) && documentNumber.length() != DocumentType.RUC.getSize())
            throw new DomainException("No valid document, required size: " + DocumentType.RUC.getSize());
    }

}
