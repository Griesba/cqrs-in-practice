package com.leretvil.cqrsinpractice.services.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditPersonalInfoCommand implements Command{
    private UUID id;
    private String name;
    private String email;

    @Override
    public String getType() {
        return "EditPersonInfo";
    }
}
