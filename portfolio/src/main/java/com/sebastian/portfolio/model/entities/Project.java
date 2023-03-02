package com.sebastian.portfolio.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Sebastian Charras
 */
@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String period;
    private Boolean completed;
    private String description;
    private String url;
}