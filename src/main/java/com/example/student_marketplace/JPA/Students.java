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
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue
    private Long id;

    private Long studentID;

    @NonNull private String firstName;
    @NonNull private String lastName;

    private Long numOfListings;
    private double rating;
    private Instant joinedAt;

}
