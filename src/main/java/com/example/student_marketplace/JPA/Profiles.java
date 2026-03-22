package com.example.student_marketplace.JPA;

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
@Table(name = "profiles")
public class Profiles{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private Long numOfListings;
    @NonNull private Double rating;
    @NonNull private Instant joinedAt;
    @NonNull private Instant updatedAt;

    @OneToOne
    @JoinColumn(name = "profileID", nullable = false)
    private LoginSystem profileID;

    @OneToMany(mappedBy = "sellerID")
    private List<Reviews> sellerReviews;
    @OneToMany(mappedBy = "buyerID")
    private List<Reviews> buyerReviews;

    @OneToMany(mappedBy = "buyerID")
    private List<Transactions> buyerTransactions;

    @OneToMany(mappedBy = "sellerID")
    private List<Transactions> sellerTransactions;





}
