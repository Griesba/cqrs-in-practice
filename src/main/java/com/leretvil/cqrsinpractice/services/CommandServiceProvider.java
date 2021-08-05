package com.leretvil.cqrsinpractice.services;

import com.leretvil.cqrsinpractice.services.commands.CommandHandler;
import com.leretvil.cqrsinpractice.services.commands.CommandHandlerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandServiceProvider {

    private final CommandHandlerFactory handlerFactory;

    public CommandHandler load(String commandName) {
        return handlerFactory.getHandler(commandName);
    }
}
