package com.leretvil.cqrsinpractice.config;

import com.leretvil.cqrsinpractice.services.commands.CommandHandlerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfig {

    @Bean("commandHandlerFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(CommandHandlerFactory.class);
        return serviceLocatorFactoryBean;
    }
}
