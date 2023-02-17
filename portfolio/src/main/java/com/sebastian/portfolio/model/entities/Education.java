package com.sebastian.portfolio.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
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
