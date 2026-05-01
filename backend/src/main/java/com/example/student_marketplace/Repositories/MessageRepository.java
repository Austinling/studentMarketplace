package com.example.student_marketplace.Repositories;

import com.example.student_marketplace.Entities.LoginSystem;
import com.example.student_marketplace.Entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Long>{
    List<Messages> findBySenderId(Long senderId);
}
