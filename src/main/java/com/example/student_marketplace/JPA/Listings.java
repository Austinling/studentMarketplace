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
@Table(name = "listings")
public class Listings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String name;
    @NonNull private String slug;
    private String description;
    @NonNull private Integer price;
    @NonNull private Integer sku;
    @NonNull private Integer status;
    private Integer stockQuantity;
    @NonNull private Instant createdAt;
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "sellerID")
    private Profiles seller;

    @OneToMany(mappedBy = "productImage")
    private List<ProductImages> productImages;

    @OneToOne(mappedBy = "transactionProduct")
    private Transactions transactionProduct;

}
