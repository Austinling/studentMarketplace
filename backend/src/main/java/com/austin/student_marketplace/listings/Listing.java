package com.austin.student_marketplace.listings;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "listingId", updatable = false, nullable = false)
    private UUID listingId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug",  nullable = false, unique = true)
    private String slug;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ListingStatus status;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;



    @ManyToMany
    @JoinTable(
            name = "listingCategories"
            , joinColumns = @JoinColumn(name = "listing_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @Override
    public String toString() {
        return "Listing{" +
                "listingId=" + listingId +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return Objects.equals(listingId, listing.listingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listingId, name, slug, description, price, status, quantity, createdAt, updatedAt, categories);
    }



}
