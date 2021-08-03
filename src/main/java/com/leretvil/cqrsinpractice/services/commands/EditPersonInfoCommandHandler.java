package com.leretvil.cqrsinpractice.services.commands;

import com.leretvil.cqrsinpractice.repository.PersonRepository;
import com.leretvil.cqrsinpractice.repository.domain.Person;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("EditPersonInfo")
@RequiredArgsConstructor
public class EditPersonInfoCommandHandler implements CommandHandler<EditPersonalInfoCommand> {

    private final PersonRepository personRepository;

    @Override
    public Result handle(EditPersonalInfoCommand command) {
        Optional<Person> personOpt =personRepository.findById(command.getId());
        if (personOpt.isEmpty()) {
            return new Result(false, "No such person");
        }
        Person person = personOpt.get();
        person.setName(command.getType());
        person.setEmail(command.getEmail());
        personRepository.save(person);
        return new Result();
    }

}
