package com.example.student_marketplace.JPA;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private Long userID;
    @NonNull private String firstName;
    @NonNull private String lastName;

    private Double rating;
    private Instant joinedAt;


}
