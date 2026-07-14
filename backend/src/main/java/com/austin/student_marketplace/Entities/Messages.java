package com.austin.student_marketplace.Entities;

import com.austin.student_marketplace.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;
    @NonNull private Instant createdAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "senderID", nullable = false)
    private User sender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recipientID", nullable = false)
    private User recipient;
}
