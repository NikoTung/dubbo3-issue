package com.example.provider.app.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnProperty(name = "dubbo.filters.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({BeanProperties.class})
public class BeanConfiguration {

    @Bean
    public BeanToInject beanToInject(BeanProperties properties) {
        return new BeanToInject(properties);
    }

}
