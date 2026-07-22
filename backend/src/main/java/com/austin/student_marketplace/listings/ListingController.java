package com.austin.student_marketplace.listings;

import com.austin.student_marketplace.listings.dto.ListingDto;
import com.austin.student_marketplace.listings.mapper.impl.ListingMapperImpl;
import com.austin.student_marketplace.listings.service.impl.ListingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
