package com.austin.student_marketplace.Repositories;

import com.austin.student_marketplace.Entities.Listings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingsRepository extends JpaRepository<ListingsRepository, Long> {
    List<Listings> findBySenderId(Long senderId);
}
