package com.austin.student_marketplace.listings.mapper;

import com.austin.student_marketplace.listings.CreateListing;
import com.austin.student_marketplace.listings.Listing;
import com.austin.student_marketplace.listings.UpdateListing;
import com.austin.student_marketplace.listings.dto.CreateListingDto;
import com.austin.student_marketplace.listings.dto.ListingDto;
import com.austin.student_marketplace.listings.dto.UpdateListingDto;

public interface ListingMapper {
    CreateListing fromDto(CreateListingDto creatingListingDto);

    UpdateListing fromDto(UpdateListingDto updateListingDto);

    ListingDto toDto(Listing listing);
}
