package com.example.student_marketplace.Repositories;

import com.example.student_marketplace.Entities.LoginSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginSystemRepository extends JpaRepository<LoginSystem, Long> {
    Optional<LoginSystem> findByEmail(String email);
    Optional<LoginSystem> findByUsername(String username);
    List<LoginSystem> findByRole(String role);

    boolean existsByEmail(String email);

}
