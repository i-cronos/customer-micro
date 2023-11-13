package pe.ibk.cpe.customer.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@ComponentScan(
        basePackages = {
                "pe.ibk.cpe.customer.application.rest",
                "pe.ibk.cpe.customer.domain.core",
                "pe.ibk.cpe.customer.domain.service",
                "pe.ibk.cpe.customer.infrastructure.database",
                "pe.ibk.cpe.customer.infrastructure.email",
                "pe.ibk.cpe.customer.infrastructure.rest",
                "pe.ibk.cpe.customer.infrastructure.sftp",
                "pe.ibk.cpe.dependencies.infrastructure.security.config"
        }
)
public class CustomerMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroApplication.class, args);
    }
}

