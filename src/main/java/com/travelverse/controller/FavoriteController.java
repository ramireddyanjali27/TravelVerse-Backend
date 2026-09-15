package com.travelverse.controller;

import com.travelverse.dto.FavoriteDTO;
import com.travelverse.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavoriteDTO>> getFavoritesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteService.getFavoritesByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<FavoriteDTO> addFavorite(@RequestBody FavoriteDTO dto) {
        try {
            return ResponseEntity.ok(favoriteService.addFavorite(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
        return ResponseEntity.ok().build();
    }
}
