package pe.ibk.cpe.customer.infrastructure.rest.local;

import pe.ibk.cpe.customer.domain.core.valueobject.Document;
import pe.ibk.cpe.customer.domain.service.ports.outbound.VerifyRiskCustomerPort;

public class VerifyRiskCustomerAdapter implements VerifyRiskCustomerPort {

    @Override
    public boolean apply(Document document) {
        return false;
    }
}
