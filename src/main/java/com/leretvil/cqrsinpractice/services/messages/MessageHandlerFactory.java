package com.leretvil.cqrsinpractice.services.messages;

public interface MessageHandlerFactory {
    MessageHandler getHandler(String name);
}
