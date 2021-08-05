package com.leretvil.cqrsinpractice.services.queries;

public interface QueryHandlerFactory {
    QueryHandler getHandler(String name);
}
