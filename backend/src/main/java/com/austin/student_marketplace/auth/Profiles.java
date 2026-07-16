package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profiles{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

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

    /*

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

     */





}
