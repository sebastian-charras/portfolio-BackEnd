package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Skill;
import com.sebastian.portfolio.model.exceptions.SkillNotFoundException;
import com.sebastian.portfolio.model.repositories.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkillController {

    private final SkillRepository skillRepository;

    @GetMapping("/api/skill")
    public List<Skill> all() {
        return skillRepository.findAll();
    }

    @GetMapping("/api/skill/{id}")
    public Skill one(@PathVariable Integer id) {
        return skillRepository.findById(id).orElseThrow(() -> new SkillNotFoundException(id));
    }

    @PostMapping("/api/skill")
    @PreAuthorize("isAuthenticated()")
    public Skill newSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @PutMapping("/api/skill/{id}")
    @PreAuthorize("isAuthenticated()")
    public Skill replaceSkill(@PathVariable Integer id, @RequestBody Skill newSkill) {
        return skillRepository.findById(id).map(skill -> {
            skill.setName(newSkill.getName());
            skill.setPercentage(newSkill.getPercentage());
            return skillRepository.save(skill);
        }).orElseGet(() -> {
            newSkill.setId(id);
            return skillRepository.save(newSkill);
        });
    }

    @DeleteMapping("/api/skill/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteController(@PathVariable Integer id) {
        skillRepository.deleteById(id);
    }
}
