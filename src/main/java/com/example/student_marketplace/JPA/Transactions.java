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

    @NonNull private Long buyerID;
    @NonNull private Long sellerID;
    @NonNull private Long productID;

    private Integer amount;
    private String status;
    @NonNull private Instant createdAt;

}
