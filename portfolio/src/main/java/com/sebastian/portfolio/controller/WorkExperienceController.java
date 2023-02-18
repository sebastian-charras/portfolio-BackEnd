package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.entities.WorkExperience;
import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import com.sebastian.portfolio.model.exceptions.WorkExperienceNotFoundException;
import com.sebastian.portfolio.model.repositories.InstitutionRepository;
import com.sebastian.portfolio.model.repositories.WorkExperienceRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian Charras
 */
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
    public WorkExperience newWorkExperience(@RequestBody WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    @PutMapping("/api/workExperience/{id}")
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
    public void deleteWorkExperience(@PathVariable Integer id) {
        workExperienceRepository.deleteById(id);
    }

    @PutMapping("/api/workExperience/{id}/institution")
    public WorkExperience addInstitution(@PathVariable Integer id, @RequestParam Integer institutionId) {
        Institution institution = institutionRepository.findById(institutionId).orElseThrow(() -> new InstitutionNotFoundException(institutionId));
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new WorkExperienceNotFoundException(id));
        workExperience.addInstitution(institution);
        return workExperienceRepository.save(workExperience);
    }

    @DeleteMapping("/api/workExperience/{id}/institution")
    public WorkExperience removeInstitution(@PathVariable Integer id) {
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new WorkExperienceNotFoundException(id));
        workExperience.removeInstitution();
        return workExperienceRepository.save(workExperience);
    }
}
