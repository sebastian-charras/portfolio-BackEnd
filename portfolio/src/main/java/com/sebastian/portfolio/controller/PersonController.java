package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Person;
import com.sebastian.portfolio.model.exceptions.PersonNotFoundException;
import com.sebastian.portfolio.model.repositories.PersonRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian Charras
 */
@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/api/person")
    public List<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/api/person/{id}")
    public Person one(@PathVariable Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping("/api/person")
    public Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/api/person/{id}")
    public Person replacePerson(@PathVariable Integer id, @RequestBody Person newPerson) {
        return personRepository.findById(id).map(person -> {
            person.setDescription(newPerson.getDescription());
            person.setEmail(newPerson.getEmail());
            person.setGithubUrl(newPerson.getGithubUrl());
            person.setLinkedinUrl(newPerson.getLinkedinUrl());
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setTitle(newPerson.getTitle());
            return personRepository.save(person);
        }).orElseGet(() -> {
            newPerson.setId(id);
            return personRepository.save(newPerson);
        });
    }

    @DeleteMapping("/api/person/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }
}
