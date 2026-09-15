package com.travelverse.controller;

import com.travelverse.entity.Experience;
import com.travelverse.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.getAllExperiences());
    }

    @GetMapping("/featured")
    public ResponseEntity<List<Experience>> getFeaturedExperiences() {
        return ResponseEntity.ok(experienceService.getFeaturedExperiences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        return ResponseEntity.ok(experienceService.getExperienceById(id));
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.createExperience(experience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.updateExperience(id, experience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return ResponseEntity.ok().build();
    }
}
