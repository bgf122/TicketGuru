package com.kineesio.TicketGuru.web.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@Configuration
public class CustomRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

    @Bean
    public Validator validatorFactory() {
        return new LocalValidatorFactoryBean();
    }


    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {

        validatingListener.addValidator("afterCreate", (org.springframework.validation.Validator) validatorFactory());
        validatingListener.addValidator("beforeCreate", (org.springframework.validation.Validator) validatorFactory());
        validatingListener.addValidator("afterSave", (org.springframework.validation.Validator) validatorFactory());
        validatingListener.addValidator("beforeSave", (org.springframework.validation.Validator) validatorFactory());
    }
}
