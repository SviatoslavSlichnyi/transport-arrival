package university.lab.arrival.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableSpringConfigured
@EntityScan("university.lab.transport.entity")
@ComponentScan(value = {
        "university.lab.transport.entity.exception",
        "university.lab.transport.entity.service",
        "university.lab.transport.entity.mapper",
})
@EnableJpaRepositories(value = {
        "university.lab.transport.entity.repository",
})
public class ComponentScanConfig {
}
