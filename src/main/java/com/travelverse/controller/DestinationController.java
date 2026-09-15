package com.travelverse.controller;

import com.travelverse.dto.DestinationDTO;
import com.travelverse.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<DestinationDTO>> getAllDestinations(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category) {
        if (search != null && !search.isEmpty()) {
            return ResponseEntity.ok(destinationService.searchDestinations(search));
        }
        if (category != null && !category.isEmpty()) {
            return ResponseEntity.ok(destinationService.getByCategory(category));
        }
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @GetMapping("/featured")
    public ResponseEntity<List<DestinationDTO>> getFeaturedDestinations() {
        return ResponseEntity.ok(destinationService.getFeaturedDestinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDTO> getDestinationById(@PathVariable Long id) {
        return ResponseEntity.ok(destinationService.getDestinationById(id));
    }

    @PostMapping
    public ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationDTO dto) {
        return ResponseEntity.ok(destinationService.createDestination(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationDTO> updateDestination(@PathVariable Long id, @RequestBody DestinationDTO dto) {
        return ResponseEntity.ok(destinationService.updateDestination(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok().build();
    }
}
