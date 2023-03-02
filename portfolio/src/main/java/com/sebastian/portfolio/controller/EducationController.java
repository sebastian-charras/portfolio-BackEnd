package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Education;
import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.exceptions.EducationNotFoundException;
import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import com.sebastian.portfolio.model.repositories.EducationRepository;
import com.sebastian.portfolio.model.repositories.InstitutionRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EducationController {

    private final EducationRepository educationRepository;
    private final InstitutionRepository institutionRepository;

    @GetMapping("/api/education")
    public List<Education> all() {
        return educationRepository.findAll();
    }

    @GetMapping("/api/education/{id}")
    public Education one(@PathVariable Integer id) {
        return educationRepository.findById(id).orElseThrow(() -> new EducationNotFoundException(id));
    }

    @PostMapping("/api/education")
    @PreAuthorize("isAuthenticated()")
    public Education newEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @PutMapping("/api/education/{id}")
    @PreAuthorize("isAuthenticated()")
    public Education replaceEducation(@PathVariable Integer id, @RequestBody Education newEducation) {
        return educationRepository.findById(id).map(education -> {
            education.setCompleted(newEducation.getCompleted());
            education.setDescription(newEducation.getDescription());
            education.setPeriod(newEducation.getPeriod());
            education.setTitle(newEducation.getTitle());
            return educationRepository.save(education);
        }).orElseGet(() -> {
            newEducation.setId(id);
            return educationRepository.save(newEducation);
        });
    }

    @DeleteMapping("/api/education/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteEducation(@PathVariable Integer id) {
        educationRepository.deleteById(id);
    }

    @PutMapping("/api/education/{id}/institution/{institutionId}")
    @PreAuthorize("isAuthenticated()")
    public Education addInstitution(@PathVariable Integer id, @PathVariable Integer institutionId) {
        Institution institution = institutionRepository.findById(institutionId).orElseThrow(() -> new InstitutionNotFoundException(institutionId));
        Education education = educationRepository.findById(id).orElseThrow(() -> new EducationNotFoundException(id));
        education.addInstitution(institution);
        return educationRepository.save(education);
    }

    @DeleteMapping("/api/education/{id}/institution")
    @PreAuthorize("isAuthenticated()")
    public Education removeInstitution(@PathVariable Integer id) {
        Education education = educationRepository.findById(id).orElseThrow(() -> new EducationNotFoundException(id));
        education.removeInstitution();
        return educationRepository.save(education);
    }
}
