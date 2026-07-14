package com.austin.student_marketplace.Entities;

import com.austin.student_marketplace.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "profileID", nullable = false)
    private User profile;

    @OneToMany(mappedBy = "reviewSeller")
    private List<Reviews> sellerReviews;
    @OneToMany(mappedBy = "reviewBuyer")
    private List<Reviews> buyerReviews;

    @OneToMany(mappedBy = "transactionBuyer")
    private List<Transactions> buyerTransactions;

    @OneToMany(mappedBy = "transactionSeller")
    private List<Transactions> sellerTransactions;

    @OneToMany(mappedBy = "listingSeller", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Listings> sellerListings;





}
