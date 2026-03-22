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
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupID;
    @NonNull private String name;
    @NonNull private String slug;
    @NonNull private Instant createdAt;

    @OneToMany(mappedBy = "category")
    private List<Listings> categoryListings;
}
