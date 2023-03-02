package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Education;
import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.entities.WorkExperience;
import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import com.sebastian.portfolio.model.repositories.EducationRepository;
import com.sebastian.portfolio.model.repositories.InstitutionRepository;
import com.sebastian.portfolio.model.repositories.WorkExperienceRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class InstitutionController {

    private final InstitutionRepository institutionRepository;
    private final EducationRepository educationRepository;
    private final WorkExperienceRepository workExperienceRepository;

    @GetMapping("/api/institution")
    public List<Institution> all() {
        return institutionRepository.findAll();
    }

    @GetMapping("/api/institution/{id}")
    public Institution one(@PathVariable Integer id) {
        return institutionRepository.findById(id).orElseThrow(() -> new InstitutionNotFoundException(id));
    }

    @PostMapping("/api/institution")
    @PreAuthorize("isAuthenticated()")
    public Institution newInstitution(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

    @PutMapping("/api/institution/{id}")
    @PreAuthorize("isAuthenticated()")
    public Institution replaceInstitution(@PathVariable Integer id, @RequestBody Institution newInstitution) {
        return institutionRepository.findById(id).map(institution -> {
            institution.setLogoUrl(newInstitution.getLogoUrl());
            institution.setName(newInstitution.getName());
            return institutionRepository.save(institution);
        }).orElseGet(() -> {
            newInstitution.setId(id);
            return institutionRepository.save(newInstitution);
        });
    }

    @DeleteMapping("/api/institution/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteInstitution(@PathVariable Integer id) {
        institutionRepository.deleteById(id);
    }

    @GetMapping("/api/institution/{id}/isReferenced")
    public Boolean isReferenced(@PathVariable Integer id) {
        Institution institution = institutionRepository.findById(id).orElseThrow(() -> new InstitutionNotFoundException(id));
        List<Education> educations = educationRepository.findAll();
        List<WorkExperience> workExperiences = workExperienceRepository.findAll();
        Boolean isReferenced = false;
        int i = 0;
        while (!isReferenced && i < educations.size()) {
            if (educations.get(i).getInstitution() != null && educations.get(i).getInstitution().equals(institution)) {
                isReferenced = true;
            } else {
                i++;
            }
        }
        i = 0;
        while (!isReferenced && i < workExperiences.size()) {
            if (workExperiences.get(i).getInstitution() != null && workExperiences.get(i).getInstitution().equals(institution)) {
                isReferenced = true;
            } else {
                i++;
            }
        }
        return isReferenced;
    }
}
