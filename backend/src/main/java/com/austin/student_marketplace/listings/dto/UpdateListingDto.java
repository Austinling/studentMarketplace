package com.austin.student_marketplace.listings.dto;

import com.austin.student_marketplace.listings.ListingStatus;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateListingDto(
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
    Double price,
    @NotBlank(message = "{listing.status.notblank}")
    @Length(max = 255, message = "{listing.length.max}")
    ListingStatus status

) {

}
 