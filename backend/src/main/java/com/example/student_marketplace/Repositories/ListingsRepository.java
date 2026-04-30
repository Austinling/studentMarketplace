package com.example.student_marketplace.Repositories;

import com.example.student_marketplace.Entities.LoginSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListingsRepository extends JpaRepository<ListingsRepository, Long> {
    Optional<LoginSystem> findById(long id);
}
