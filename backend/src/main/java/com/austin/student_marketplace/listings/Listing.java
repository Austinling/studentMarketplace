package com.austin.student_marketplace.listings;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    private Integer price;

    @Column(name = "sku", nullable = false, updatable = false)
    Integer sku;

    @Column(name = "status", nullable = false)
    private Integer status;

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
                ", sku=" + sku +
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
        return Objects.equals(listingId, listing.listingId) && Objects.equals(name, listing.name) && Objects.equals(slug, listing.slug) && Objects.equals(description, listing.description) && Objects.equals(price, listing.price) && Objects.equals(sku, listing.sku) && Objects.equals(status, listing.status) && Objects.equals(quantity, listing.quantity) && Objects.equals(createdAt, listing.createdAt) && Objects.equals(updatedAt, listing.updatedAt) && Objects.equals(categories, listing.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listingId, name, slug, description, price, sku, status, quantity, createdAt, updatedAt, categories);
    }



}
