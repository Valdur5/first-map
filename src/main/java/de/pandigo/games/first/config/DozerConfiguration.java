package de.pandigo.games.first.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {
    // TODO duplicated in every micro service
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        return new DozerBeanMapper();
    }
}
