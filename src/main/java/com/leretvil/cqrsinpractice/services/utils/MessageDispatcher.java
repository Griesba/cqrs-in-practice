package com.leretvil.cqrsinpractice.services.utils;

import com.leretvil.cqrsinpractice.services.CommandServiceProvider;
import com.leretvil.cqrsinpractice.services.QueryServiceProvider;
import com.leretvil.cqrsinpractice.services.commands.Command;
import com.leretvil.cqrsinpractice.services.commands.CommandHandler;
import com.leretvil.cqrsinpractice.services.queries.Query;
import com.leretvil.cqrsinpractice.services.queries.QueryHandler;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageDispatcher {

    private final CommandServiceProvider commandServiceProvider;
    private final QueryServiceProvider queryServiceProvider;

    public Result dispatch(Command command){
        CommandHandler handler = commandServiceProvider.load(command.getType());
        return handler.handle(command);
    }

    public <T> T dispatch(Query<T> query) {
        QueryHandler<Query<T>, T> queryHandler = queryServiceProvider.load(query.getType());
        return queryHandler.handle(query);
    }
}
