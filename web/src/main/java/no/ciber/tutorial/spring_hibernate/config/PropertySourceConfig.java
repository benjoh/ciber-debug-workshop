package no.ciber.tutorial.spring_hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertySourceConfig {

    private static final String PROPERTIES_FILE = "config.properties";

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        pspc.setLocation(new ClassPathResource(PROPERTIES_FILE));
        return pspc;
    }
}
