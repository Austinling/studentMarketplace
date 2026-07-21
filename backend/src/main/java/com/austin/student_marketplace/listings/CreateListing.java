package com.austin.student_marketplace.listings;

public record CreateListing(
        String name,
        String description,
        Integer quantity,
        Double price
        ) {
}
