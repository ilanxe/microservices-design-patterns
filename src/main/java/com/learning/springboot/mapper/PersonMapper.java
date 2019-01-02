package com.learning.springboot.mapper;

import com.learning.springboot.dto.PersonDto;
import com.learning.springboot.model.Person;
import org.mapstruct.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    default Mono<PersonDto> entityToDto(Mono<Person> person) {
        return person.map(p -> map(p));
    }

    default Flux<PersonDto> entityToDto(Flux<Person> persons) {
        return persons.map(p -> map(p));
    }

    Person dtoToEntity(PersonDto personDto);

    List<Person> map(List<PersonDto> persons);

    PersonDto map(Person person);
}
