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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull private Long userID;
    @NonNull private String firstName;
    @NonNull private String lastName;

    private Double rating;
    private Instant joinedAt;


}
