package com.austin.student_marketplace.listings;

public record UpdateListing(
        String name,
        String description,
        Integer quantity,
        Double price,
        ListingStatus status
        ) {
}
