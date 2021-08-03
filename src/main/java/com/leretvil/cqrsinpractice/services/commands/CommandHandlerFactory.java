package com.leretvil.cqrsinpractice.services.commands;

public interface CommandHandlerFactory {

    CommandHandler getHandler(String name);
}
