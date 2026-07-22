package com.austin.student_marketplace.listings.mapper;

import com.austin.student_marketplace.listings.CreateListing;
import com.austin.student_marketplace.listings.Listing;
import com.austin.student_marketplace.listings.dto.CreateListingDto;
import com.austin.student_marketplace.listings.dto.ListingDto;

public interface ListingMapper {
    CreateListing fromDto(CreateListingDto creatingListingDto);

    ListingDto toDto(Listing listing);
}
