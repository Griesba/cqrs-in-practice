package com.leretvil.cqrsinpractice.config;

import com.leretvil.cqrsinpractice.services.queries.QueryHandlerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryConfig {

    @Bean("queryHandlerFactory")
    public FactoryBean getQueryServiceFactory(){
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(QueryHandlerFactory.class);
        return serviceLocatorFactoryBean;
    }
}
