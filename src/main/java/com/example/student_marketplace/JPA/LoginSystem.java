package com.example.student_marketplace.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "loginSystem")
public class LoginSystem {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull private String username;
    @NonNull String email;
    @NonNull private String role;
    @NonNull private String password_hash;
    @NonNull private Instant joined_at;
    private Instant updated_at;
}
