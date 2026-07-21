package com.austin.student_marketplace.listings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface authRepository extends JpaRepository<Listing, UUID> {

}
