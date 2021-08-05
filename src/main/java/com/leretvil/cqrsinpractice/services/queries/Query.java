package com.leretvil.cqrsinpractice.services.queries;

import com.leretvil.cqrsinpractice.services.messages.MessageType;

public interface Query<TResult> {
    String getType();
}
