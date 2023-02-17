package com.sebastian.portfolio.model.repositories;

import com.sebastian.portfolio.model.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian Charras
 */
@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    
}
