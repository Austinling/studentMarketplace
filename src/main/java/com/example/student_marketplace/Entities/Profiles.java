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
    private LoginSystem profile;

    @OneToMany(mappedBy = "reviewSellerID")
    private List<Reviews> sellerReviews;
    @OneToMany(mappedBy = "reviewBuyerID")
    private List<Reviews> buyerReviews;

    @OneToMany(mappedBy = "transactionBuyerID")
    private List<Transactions> buyerTransactions;

    @OneToMany(mappedBy = "transactionSellerID")
    private List<Transactions> sellerTransactions;

    @OneToMany(mappedBy = "listingSellerID", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Listings> sellerListings;





}
