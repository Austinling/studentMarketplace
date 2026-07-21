package com.austin.student_marketplace.listings.dto;

import com.austin.student_marketplace.listings.ListingStatus;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ListingDto(
        String name,
        String description,
        Integer quantity,
        Double price,
        ListingStatus status
) {
}
