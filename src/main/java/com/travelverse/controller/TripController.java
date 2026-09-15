package com.travelverse.controller;

import com.travelverse.dto.ItineraryItemDTO;
import com.travelverse.dto.TripDTO;
import com.travelverse.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TripDTO>> getTripsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(tripService.getTripsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO dto) {
        return ResponseEntity.ok(tripService.createTrip(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripDTO> updateTrip(@PathVariable Long id, @RequestBody TripDTO dto) {
        return ResponseEntity.ok(tripService.updateTrip(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok().build();
    }

    // Itinerary endpoints
    @GetMapping("/{tripId}/itinerary")
    public ResponseEntity<List<ItineraryItemDTO>> getItineraryItems(@PathVariable Long tripId) {
        return ResponseEntity.ok(tripService.getItineraryItems(tripId));
    }

    @PostMapping("/{tripId}/itinerary")
    public ResponseEntity<ItineraryItemDTO> addItineraryItem(@PathVariable Long tripId, @RequestBody ItineraryItemDTO dto) {
        return ResponseEntity.ok(tripService.addItineraryItem(tripId, dto));
    }

    @PutMapping("/itinerary/{id}")
    public ResponseEntity<ItineraryItemDTO> updateItineraryItem(@PathVariable Long id, @RequestBody ItineraryItemDTO dto) {
        return ResponseEntity.ok(tripService.updateItineraryItem(id, dto));
    }

    @DeleteMapping("/itinerary/{id}")
    public ResponseEntity<Void> deleteItineraryItem(@PathVariable Long id) {
        tripService.deleteItineraryItem(id);
        return ResponseEntity.ok().build();
    }
}
