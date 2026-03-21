package com.example.student_marketplace.JPA;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private Integer sellerID;
    @NonNull private Integer buyerID;

    private String body;
    @NonNull private Double rating;
}
