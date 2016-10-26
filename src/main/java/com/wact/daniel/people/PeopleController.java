package com.wact.daniel.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController
{
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(final PeopleRepository peopleRepository)
    {
        this.peopleRepository = peopleRepository;
    }

    @RequestMapping
    @ResponseBody
    List<Person> allPeople()
    {
        return peopleRepository.findAllPeople();
    }

    @RequestMapping("{name}")
    ResponseEntity<Person> personByName(@PathVariable("name") final String name)
    {
        return peopleRepository.findPersonByName(name)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PersonNotFoundException("No person found with name: '" + name + "'"));
    }
}
