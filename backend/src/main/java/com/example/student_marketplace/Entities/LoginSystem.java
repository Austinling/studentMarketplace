package com.example.student_marketplace.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loginSystem")
public class LoginSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String username;
    @NonNull String email;
    @NonNull private String role;
    @NonNull private String password_hash;
    @NonNull private Instant joined_at;
    private Instant updated_at;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profiles profile;

    @OneToMany(mappedBy = "sender")
    private List<Messages> senderMessages;

    @OneToMany(mappedBy = "recipient")
    private List<Messages> recipientMessages;
}
