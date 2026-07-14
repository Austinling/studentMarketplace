package com.austin.student_marketplace.Repositories;

import com.austin.student_marketplace.Entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Long>{
    List<Messages> findBySenderId(Long senderId);
}
