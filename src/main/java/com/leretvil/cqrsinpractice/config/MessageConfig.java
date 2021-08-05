package com.leretvil.cqrsinpractice.config;

import com.leretvil.cqrsinpractice.services.messages.MessageHandlerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean("messageHandlerFactory")
    public FactoryBean<Object> getMessageHandler(){
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(MessageHandlerFactory.class);
        return serviceLocatorFactoryBean;
    }
}
