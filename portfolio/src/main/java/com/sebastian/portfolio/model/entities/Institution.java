package com.sebastian.portfolio.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
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
