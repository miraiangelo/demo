package org.person.demo.repository;

import org.person.demo.model.Person;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface PersonRepository extends MongoRepository<Person,String> {

}
