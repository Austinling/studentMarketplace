package com.austin.student_marketplace.listings;

import lombok.Builder;

import java.util.Set;

@Builder
public record UpdateListing(
        String name,
        String description,
        Integer quantity,
        Double price,
        ListingStatus status,
        Set<Category>categories
        ) {
}
