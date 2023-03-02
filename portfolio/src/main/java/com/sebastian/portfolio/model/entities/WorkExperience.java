package com.sebastian.portfolio.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Sebastian Charras
 */
@Entity
@Table(name = "work_experience")
@Data
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "institution")
    private Institution institution;
    private String title;
    private String period;
    private Boolean completed;
    private String description;

    public void addInstitution(Institution institution) {
        this.institution = institution;
        institution.getWorkExperiences().add(this);
    }

    public void removeInstitution() {
        institution.getWorkExperiences().remove(this);
        this.institution = null;
    }
}
