package com.leretvil.cqrsinpractice.services.commands;

import com.leretvil.cqrsinpractice.web.model.Result;

public interface CommandHandler<TCommand extends Command> {

    Result handle(TCommand command);
}
