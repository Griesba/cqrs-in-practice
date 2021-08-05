package com.leretvil.cqrsinpractice.services.commands;

import com.leretvil.cqrsinpractice.services.CommandServiceProvider;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseRetryDecorator implements CommandHandler<EditPersonalInfoCommand>{

    private final CommandServiceProvider commandServiceProvider;

    @Override
    public Result handle(EditPersonalInfoCommand command) {

        for (int i = 0; i < 3; i++) {
            try {
                return commandServiceProvider.load(command.getType()).handle(command);
            }catch (Exception e){
                if (i >= 3) throw new RuntimeException(e.getMessage());
            }
        }
        throw new RuntimeException("Database retry failed");
    }
}
