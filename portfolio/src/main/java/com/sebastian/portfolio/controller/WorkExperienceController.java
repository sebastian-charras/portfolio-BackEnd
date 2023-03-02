package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.entities.WorkExperience;
import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import com.sebastian.portfolio.model.exceptions.WorkExperienceNotFoundException;
import com.sebastian.portfolio.model.repositories.InstitutionRepository;
import com.sebastian.portfolio.model.repositories.WorkExperienceRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WorkExperienceController {

    private final WorkExperienceRepository workExperienceRepository;
    private final InstitutionRepository institutionRepository;

    @GetMapping("/api/workExperience")
    public List<WorkExperience> all() {
        return workExperienceRepository.findAll();
    }

    @GetMapping("/api/workExperience/{id}")
    public WorkExperience one(@PathVariable Integer id) {
        return workExperienceRepository.findById(id).orElseThrow(() -> new WorkExperienceNotFoundException(id));
    }

    @PostMapping("/api/workExperience")
    @PreAuthorize("isAuthenticated()")
    public WorkExperience newWorkExperience(@RequestBody WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    @PutMapping("/api/workExperience/{id}")
    @PreAuthorize("isAuthenticated()")
    public WorkExperience replaceWorkExperience(@PathVariable Integer id, @RequestBody WorkExperience newWorkExperience) {
        return workExperienceRepository.findById(id).map(workExperience -> {
            workExperience.setCompleted(newWorkExperience.getCompleted());
            workExperience.setDescription(newWorkExperience.getDescription());
            workExperience.setPeriod(newWorkExperience.getPeriod());
            workExperience.setTitle(newWorkExperience.getTitle());
            return workExperienceRepository.save(workExperience);
        }).orElseGet(() -> {
            newWorkExperience.setId(id);
            return workExperienceRepository.save(newWorkExperience);
        });
    }

    @DeleteMapping("/api/workExperience/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteWorkExperience(@PathVariable Integer id) {
        workExperienceRepository.deleteById(id);
    }

    @PutMapping("/api/workExperience/{id}/institution/{institutionId}")
    @PreAuthorize("isAuthenticated()")
    public WorkExperience addInstitution(@PathVariable Integer id, @PathVariable Integer institutionId) {
        Institution institution = institutionRepository.findById(institutionId).orElseThrow(() -> new InstitutionNotFoundException(institutionId));
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new WorkExperienceNotFoundException(id));
        workExperience.addInstitution(institution);
        return workExperienceRepository.save(workExperience);
    }

    @DeleteMapping("/api/workExperience/{id}/institution")
    @PreAuthorize("isAuthenticated()")
    public WorkExperience removeInstitution(@PathVariable Integer id) {
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new WorkExperienceNotFoundException(id));
        workExperience.removeInstitution();
        return workExperienceRepository.save(workExperience);
    }
}
