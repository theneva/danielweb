package com.wact.daniel.people;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PeopleRepository
{
    final List<Person> people = Arrays.asList(
            new Person("Daniel"),
            new Person("Martin")
    );

    public List<Person> findAllPeople()
    {
        return people;
    }

    public Optional<Person> findPersonByName(final String name)
    {
        Objects.requireNonNull(name);

        return people.stream()
                .filter(person -> name.equals(person.name))
                .findAny();
    }
}
