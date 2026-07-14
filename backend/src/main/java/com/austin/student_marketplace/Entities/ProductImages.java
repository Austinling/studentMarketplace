package com.austin.student_marketplace.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_images")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String url;
    @NonNull private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Listings productImage;
}
