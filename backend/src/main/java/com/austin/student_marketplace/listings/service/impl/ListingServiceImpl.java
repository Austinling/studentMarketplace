package com.austin.student_marketplace.listings.service.impl;

import com.austin.student_marketplace.Exceptions.ListingException;
import com.austin.student_marketplace.listings.*;
import com.austin.student_marketplace.listings.service.ListingService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ListingServiceImpl implements ListingService {
    private final ListingRepository listingRepository;

    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public Listing createListing(CreateListing createListing) {
        Instant now =  Instant.now();
        Listing listing = Listing.builder().
                listingId(null)
                .name(createListing.name())
                .slug(createSlug(createListing.name()))
                .description(createListing.description())
                .price(createListing.price())
                .categories(createListing.categories())
                .build();

        return listingRepository.save(listing);
    }

    @Override
    public Listing updateListing(UUID listingId, UpdateListing updateListing) {
        Listing listing = listingRepository.findById(listingId).orElseThrow(()-> new ListingException("listing not found"));
        listing.setName(updateListing.name());
        listing.setDescription(updateListing.description());
        listing.setPrice(updateListing.price());
        listing.setCategories(updateListing.categories());

        return listingRepository.save(listing);
    }

    @Override
    public List<Listing> listListings() {
        return listingRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    @Override
    public void deleteListing(UUID listingId) {
        listingRepository.deleteById(listingId);
    }

    private static String createSlug(String name){
        String baseSlug = name.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");

        String uuid = UUID.randomUUID().toString().substring(0,8);

        return baseSlug+ "_" + uuid;
    }
}
