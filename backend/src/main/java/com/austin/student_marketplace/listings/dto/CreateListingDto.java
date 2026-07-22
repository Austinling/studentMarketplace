package com.austin.student_marketplace.listings.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;

@Builder
public record CreateListingDto(
    @NotBlank(message = "{listing.name.notblank}")
    @Length(max = 255, message = "{listing.length.max}")
    String name,
    @Length(max = 255, message = "{listing.length.max}")
    String description,
    @NotBlank(message = "{listing.quantity.notblank}")
    @Length(max = 255, message = "{listing.length.max}")
    Integer quantity,
    @NotBlank(message = "{listing.price.notblank}")
    @Length(max = 255, message = "{listing.length.max}")
    Double price
) {

}
