package com.example.student_marketplace.Entities;

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
    @JoinColumn(name = "senderID", nullable = false)
    private LoginSystem sender;

    @ManyToOne
    @JoinColumn(name = "recipientID", nullable = false)
    private LoginSystem recipient;
}
