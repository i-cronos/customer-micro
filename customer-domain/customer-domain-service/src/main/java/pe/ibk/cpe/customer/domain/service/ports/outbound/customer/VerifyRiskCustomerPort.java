package pe.ibk.cpe.customer.domain.service.ports.outbound.customer;

import pe.ibk.cpe.customer.domain.core.valueobject.Document;

public interface VerifyRiskCustomerPort {

    boolean apply(Document document);
}
