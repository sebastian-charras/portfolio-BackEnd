package com.sebastian.portfolio.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Sebastian Charras
 */
@Entity
@Table(name = "skill")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer percentage;
}
