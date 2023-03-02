package com.sebastian.portfolio.model.repositories;

import com.sebastian.portfolio.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sebastian Charras
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
