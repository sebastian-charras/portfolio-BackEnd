package com.sebastian.portfolio.model.repositories;

import com.sebastian.portfolio.model.entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sebastian Charras
 */
@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer> {

}
