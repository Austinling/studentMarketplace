package com.austin.student_marketplace.listings.mapper.impl;

import com.austin.student_marketplace.listings.CreateListing;
import com.austin.student_marketplace.listings.Listing;
import com.austin.student_marketplace.listings.UpdateListing;
import com.austin.student_marketplace.listings.dto.CreateListingDto;
import com.austin.student_marketplace.listings.dto.ListingDto;
import com.austin.student_marketplace.listings.dto.UpdateListingDto;
import com.austin.student_marketplace.listings.mapper.ListingMapper;
import org.springframework.stereotype.Component;

@Component
public class ListingMapperImpl implements ListingMapper {
    @Override
    public CreateListing fromDto(CreateListingDto createListingDto) {
        return CreateListing.builder().name(createListingDto.name())
                .description(createListingDto.description())
                .quantity(createListingDto.quantity())
                .price(createListingDto.price())
                .categories(createListingDto.categories())
                .build();

    }

    @Override
    public UpdateListing fromDto(UpdateListingDto updateListingDto) {
        return UpdateListing.builder()
                .name(updateListingDto.name())
                .description(updateListingDto.description())
                .quantity(updateListingDto.quantity())
                .price(updateListingDto.price())
                .status(updateListingDto.status())
                .categories(updateListingDto.categories())
                .build();
    }

    @Override
    public ListingDto toDto(Listing listing) {
        return ListingDto.builder()
                .name(listing.getName())
                .description(listing.getDescription())
                .price(listing.getPrice())
                .quantity(listing.getQuantity())
                .status(listing.getStatus())
                .build();
    }


}
