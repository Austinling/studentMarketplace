package com.austin.student_marketplace.listings.service;

import com.austin.student_marketplace.listings.CreateListing;
import com.austin.student_marketplace.listings.Listing;
import com.austin.student_marketplace.listings.UpdateListing;

import java.util.List;
import java.util.UUID;

public interface ListingService {
    Listing createListing(CreateListing createListing);

    Listing updateListing(UUID listingId, UpdateListing updateListing);

    List<Listing> listListings();

    void deleteListing(UUID listingId);

}
