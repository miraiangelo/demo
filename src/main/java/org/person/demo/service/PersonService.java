package org.person.demo.service;

import org.person.demo.model.Person;
import org.person.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person addPerson(Person person){
        person.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(person);
    }
    public String deletePerson(String id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return id+" Person deleted ";
        }
        return "Person does not exists in the document";
    }

    public Person updatePerson(String id,Person person){
        Person person1 = new Person();
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        return repository.existsById(id) ? repository.save(person): person;
    }

    public Person getPerson(String id){
        return repository.findById(id).get();
    }

    public List<Person> getAllPeople(){
        return repository.findAll();
    }
}
