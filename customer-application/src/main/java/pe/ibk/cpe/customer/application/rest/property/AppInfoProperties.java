package pe.ibk.cpe.customer.application.rest.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("app.info")
public class AppInfoProperties {
    private String name;
    private String env;
}
