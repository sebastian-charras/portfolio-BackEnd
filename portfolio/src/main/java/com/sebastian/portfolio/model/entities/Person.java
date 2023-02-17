package com.sebastian.portfolio.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Sebastian Charras
 */
@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String title;
    private String description;
    private String email;
    @Column(name = "github_url")
    private String githubUrl;
    @Column(name = "linkedin_url")
    private String linkedinUrl;
}
