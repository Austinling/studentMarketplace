package com.austin.student_marketplace.listings;

import lombok.Builder;

import java.util.Set;

@Builder
public record CreateListing(
        String name,
        String description,
        Integer quantity,
        Double price,
        Set<Category>categories
        ) {
}
