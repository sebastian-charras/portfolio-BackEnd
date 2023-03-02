package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Person;
import com.sebastian.portfolio.model.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/api/person")
    public Person one() {
        return personRepository.findAll().get(0);
    }

    @PutMapping("/api/person/{id}")
    @PreAuthorize("isAuthenticated()")
    public Person replacePerson(@PathVariable Integer id, @RequestBody Person newPerson) {
        return personRepository.findById(id).map(person -> {
            person.setDescription(newPerson.getDescription());
            person.setEmail(newPerson.getEmail());
            person.setGithubUrl(newPerson.getGithubUrl());
            person.setLinkedinUrl(newPerson.getLinkedinUrl());
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setTitle(newPerson.getTitle());
            person.setProfilePictureUrl(newPerson.getProfilePictureUrl());
            person.setCatchPhrase(newPerson.getCatchPhrase());
            person.setHeroImageUrl(newPerson.getHeroImageUrl());
            return personRepository.save(person);
        }).orElseGet(() -> {
            newPerson.setId(id);
            return personRepository.save(newPerson);
        });
    }

}
