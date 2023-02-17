package com.sebastian.portfolio.model.repositories;

import com.sebastian.portfolio.model.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian Charras
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    
}
