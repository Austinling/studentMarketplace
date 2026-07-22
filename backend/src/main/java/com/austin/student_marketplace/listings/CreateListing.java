package com.austin.student_marketplace.listings;

import lombok.Builder;

@Builder
public record CreateListing(
        String name,
        String description,
        Integer quantity,
        Double price
        ) {
}
