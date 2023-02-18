package com.sebastian.portfolio.controller;

import com.sebastian.portfolio.model.entities.Institution;
import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import com.sebastian.portfolio.model.repositories.InstitutionRepository;
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
public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    @GetMapping("/api/institution")
    public List<Institution> all() {
        return institutionRepository.findAll();
    }

    @GetMapping("/api/institution/{id}")
    public Institution one(@PathVariable Integer id) {
        return institutionRepository.findById(id).orElseThrow(() -> new InstitutionNotFoundException(id));
    }

    @PostMapping("/api/institution")
    public Institution newInstitution(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

    @PutMapping("/api/institution/{id}")
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
    public void deleteInstitution(@PathVariable Integer id) {
        institutionRepository.deleteById(id);
    }
}
