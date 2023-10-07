package pe.ibk.cpe.customer.domain.core.customer.valueobject;


public class BusinessName {
    private final SocietyType societyType;
    private final String name;

    public BusinessName(SocietyType societyType, String name) {
        this.societyType = societyType;
        this.name = name;
    }

    public SocietyType getSocietyType() {
        return societyType;
    }

    public String getName() {
        return name;
    }
}
