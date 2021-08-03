package com.leretvil.cqrsinpractice.services;

import com.leretvil.cqrsinpractice.services.commands.Command;
import com.leretvil.cqrsinpractice.services.commands.CommandHandler;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Messages {

    private final ServiceProvider serviceProvider;

    public Result dispatch(Command command){
        CommandHandler handler = serviceProvider.load(command.getType());
        return handler.handle(command);
    }
}
