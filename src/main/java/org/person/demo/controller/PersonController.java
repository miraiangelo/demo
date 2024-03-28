package org.person.demo.controller;

import lombok.AllArgsConstructor;
import org.person.demo.model.Person;
import org.person.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person make(@RequestBody Person person){
        return service.addPerson(person);
    }

    @GetMapping
    public List<Person> people(){
        return service.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id){
        return service.getPerson(id);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id){
        return service.deletePerson(id);
    }

}
