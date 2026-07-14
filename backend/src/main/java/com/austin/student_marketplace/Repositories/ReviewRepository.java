package com.austin.student_marketplace.Repositories;

import com.austin.student_marketplace.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findBySenderId(Long senderId);
}
