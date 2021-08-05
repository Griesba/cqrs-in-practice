package com.leretvil.cqrsinpractice.services;

import com.leretvil.cqrsinpractice.services.queries.Query;
import com.leretvil.cqrsinpractice.services.queries.QueryHandler;
import com.leretvil.cqrsinpractice.services.queries.QueryHandlerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryServiceProvider {

    private final QueryHandlerFactory queryHandlerFactory;

    public <T> QueryHandler<Query<T>, T> load(String queryType){
        return queryHandlerFactory.getHandler(queryType);
    }
}
