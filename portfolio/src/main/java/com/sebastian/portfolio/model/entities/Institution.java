package com.sebastian.portfolio.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Sebastian Charras
 */
@Entity
@Table(name = "institution")
@Data
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "logo_url")
    private String logoUrl;
    @OneToMany(mappedBy = "institution", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Education> educations = new ArrayList<>();
    @OneToMany(mappedBy = "institution", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<WorkExperience> workExperiences = new ArrayList<>();
}
