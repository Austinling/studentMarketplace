package com.austin.student_marketplace.auth;

import com.austin.student_marketplace.audit.TimestampDetails;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profile extends TimestampDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "numOfListings", nullable = false)
    private Long numOfListings;

    @Column(name = "rating", nullable = false)
    private Double rating;

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
