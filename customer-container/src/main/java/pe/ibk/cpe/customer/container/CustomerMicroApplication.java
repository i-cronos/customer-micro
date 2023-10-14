package pe.ibk.cpe.customer.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
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
        ApplicationContext applicationContext = SpringApplication.run(CustomerMicroApplication.class, args);

        print(applicationContext);
    }

    private static void print(ApplicationContext applicationContext) {
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
            System.out.println((1 + i) + " ::: " + beans[i]);
        }
    }
}

