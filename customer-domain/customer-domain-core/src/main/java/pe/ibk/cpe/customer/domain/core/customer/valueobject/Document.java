package pe.ibk.cpe.customer.domain.core.customer.valueobject;

import pe.ibk.cpe.dependencies.common.exception.BaseException;
import pe.ibk.cpe.dependencies.common.exception.DomainException;

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
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("No valid document, required size: " + DocumentType.DNI.getSize())
                    .userMessage("No valid dni")
                    .build());

        if (documentType.equals(DocumentType.RUC) && documentNumber.length() != DocumentType.RUC.getSize())
            throw new DomainException(BaseException.Error.builder()
                    .systemMessage("No valid document, required size: " + DocumentType.RUC.getSize())
                    .userMessage("Not valid ruc")
                    .build());
    }

}
