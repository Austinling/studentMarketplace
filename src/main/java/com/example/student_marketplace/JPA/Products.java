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
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private Long studentID;
    @NonNull private Long categoryID;
    @NonNull private String name;
    @NonNull private String slug;
    private String description;
    @NonNull private Integer price;
    @NonNull private Integer sku;
    @NonNull private Integer status;
    private Integer stockQuantity;
    @NonNull private Instant createdAt;
    private Instant updatedAt;

}
