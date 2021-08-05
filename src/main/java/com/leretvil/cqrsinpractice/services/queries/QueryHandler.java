package com.leretvil.cqrsinpractice.services.queries;

public interface QueryHandler <TQuery extends Query<TResult>, TResult>  {

    TResult handle(TQuery query);
}
