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
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;
    private String status;
    @NonNull private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "buyerID")
    private Profiles transactionBuyer;

    @ManyToOne
    @JoinColumn(name = "sellerID")
    private Profiles transactionSeller;

    @OneToOne
    @JoinColumn(name = "productID")
    private Listings transactionProduct;

}
