package com.travelverse.controller;

import com.travelverse.dto.PackageDTO;
import com.travelverse.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAllPackages(
            @RequestParam(required = false) String destination) {
        if (destination != null && !destination.isEmpty()) {
            return ResponseEntity.ok(packageService.getByDestination(destination));
        }
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    @GetMapping("/featured")
    public ResponseEntity<List<PackageDTO>> getFeaturedPackages() {
        return ResponseEntity.ok(packageService.getFeaturedPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageDTO> getPackageById(@PathVariable Long id) {
        return ResponseEntity.ok(packageService.getPackageById(id));
    }

    @PostMapping
    public ResponseEntity<PackageDTO> createPackage(@RequestBody PackageDTO dto) {
        return ResponseEntity.ok(packageService.createPackage(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageDTO> updatePackage(@PathVariable Long id, @RequestBody PackageDTO dto) {
        return ResponseEntity.ok(packageService.updatePackage(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok().build();
    }
}
