package com.sebastian.portfolio.model.repositories;

import com.sebastian.portfolio.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
