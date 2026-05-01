package com.example.student_marketplace.Repositories;

import com.example.student_marketplace.Entities.Listings;
import com.example.student_marketplace.Entities.LoginSystem;
import com.example.student_marketplace.Entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListingsRepository extends JpaRepository<ListingsRepository, Long> {
    List<Listings> findBySenderId(Long senderId);
}
