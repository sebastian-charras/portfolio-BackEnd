package com.sebastian.portfolio.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
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
    @Column(name = "profile_picture_url")
    private String profilePictureUrl;
    @Column(name = "hero_image_url")
    private String heroImageUrl;
    @Column(name = "catch_phrase")
    private String catchPhrase;
}
