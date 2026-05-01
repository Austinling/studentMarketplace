package com.example.student_marketplace.Repositories;

import com.example.student_marketplace.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findBySenderId(Long senderId);
}
