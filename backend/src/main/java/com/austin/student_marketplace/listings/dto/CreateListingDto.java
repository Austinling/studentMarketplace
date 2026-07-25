package com.austin.student_marketplace.listings.dto;

import com.austin.student_marketplace.listings.Category;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;

import java.util.Set;

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
    Double price,
    Set<Category> categories
) {

}
