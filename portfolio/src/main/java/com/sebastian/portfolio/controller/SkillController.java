package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Skill;
import com.sebastian.portfolio.model.exceptions.SkillNotFoundException;
import com.sebastian.portfolio.model.repositories.SkillRepository;
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
    public Skill newSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @PutMapping("/api/skill/{id}")
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
    public void deleteController(@PathVariable Integer id) {
        skillRepository.deleteById(id);
    }
}
