package com.austin.student_marketplace.listings;

import com.austin.student_marketplace.listings.dto.CreateListingDto;
import com.austin.student_marketplace.listings.dto.ListingDto;
import com.austin.student_marketplace.listings.dto.UpdateListingDto;
import com.austin.student_marketplace.listings.mapper.impl.ListingMapperImpl;
import com.austin.student_marketplace.listings.service.impl.ListingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/listing")
@CrossOrigin(origins = "http://localhost:3000")
public class ListingController {

    private final ListingServiceImpl listingServiceImpl;
    private final ListingMapperImpl listingMapperImpl;

    public ListingController(ListingServiceImpl listingServiceImpl,
                             ListingMapperImpl listingMapperImpl) {
        this.listingServiceImpl = listingServiceImpl;
        this.listingMapperImpl = listingMapperImpl;
    }

    @GetMapping
    public ResponseEntity<List<ListingDto>> getAllListings(){
        List<Listing> listings = listingServiceImpl.listListings();
        List<ListingDto> listingDtos = listings.stream().map(listingMapperImpl::toDto).toList();

        return ResponseEntity.ok(listingDtos);
    }

    @PostMapping
    public ResponseEntity<ListingDto> createListing(
            @RequestBody
            @Valid
            CreateListingDto createListingDto
    ){
        CreateListing createListing = listingMapperImpl.fromDto(createListingDto);
        Listing listing = listingServiceImpl.createListing(createListing);
        ListingDto listingDto = listingMapperImpl.toDto(listing);

        return new ResponseEntity<>(listingDto, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{listingId}")
    public ResponseEntity<ListingDto> updateListing(
            @PathVariable UUID listingId,
            @RequestBody @Valid
            UpdateListingDto updateListingDto
    ){
        UpdateListing updateListing = listingMapperImpl.fromDto(updateListingDto);
        Listing listing = listingServiceImpl.updateListing(listingId, updateListing);
        ListingDto listingDto = listingMapperImpl.toDto(listing);

        return ResponseEntity.ok(listingDto);
    }

    @DeleteMapping(path = "/{listingId}")
    public ResponseEntity<Void>  deleteListing(
            @PathVariable UUID listingId
    ){
        listingServiceImpl.deleteListing(listingId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
