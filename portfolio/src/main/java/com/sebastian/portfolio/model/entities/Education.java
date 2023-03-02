package com.sebastian.portfolio.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Sebastian Charras
 */
@Entity
@Table(name = "education")
@Data
public class Education implements Serializable {

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
        institution.getEducations().add(this);
    }

    public void removeInstitution() {
        institution.getEducations().remove(this);
        this.institution = null;
    }
}
