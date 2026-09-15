package com.travelverse.service;

import com.travelverse.dto.PackageDTO;
import com.travelverse.entity.Destination;
import com.travelverse.entity.TravelPackage;
import com.travelverse.repository.DestinationRepository;
import com.travelverse.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageService {

    @Autowired
    private TravelPackageRepository packageRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    public List<PackageDTO> getAllPackages() {
        return packageRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PackageDTO> getFeaturedPackages() {
        return packageRepository.findByFeaturedTrue().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PackageDTO getPackageById(Long id) {
        TravelPackage pkg = packageRepository.findById(id).orElseThrow(() -> new RuntimeException("Package not found"));
        return toDTO(pkg);
    }

    public List<PackageDTO> getByDestination(String destination) {
        return packageRepository.findByDestinationContainingIgnoreCase(destination).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PackageDTO createPackage(PackageDTO dto) {
        TravelPackage pkg = new TravelPackage();
        pkg.setName(dto.getName());
        pkg.setDestination(dto.getDestination());
        pkg.setDuration(dto.getDuration());
        pkg.setPrice(dto.getPrice());
        pkg.setDescription(dto.getDescription());
        pkg.setRating(dto.getRating() != null ? dto.getRating() : java.math.BigDecimal.ZERO);
        pkg.setImage(dto.getImage());
        pkg.setItinerary(dto.getItinerary());
        pkg.setHotels(dto.getHotels());
        pkg.setActivities(dto.getActivities());
        pkg.setTransportation(dto.getTransportation());
        pkg.setMeals(dto.getMeals());
        pkg.setInclusions(dto.getInclusions());
        pkg.setExclusions(dto.getExclusions());
        pkg.setFeatured(dto.getFeatured() != null ? dto.getFeatured() : false);

        if (dto.getDestinationId() != null) {
            Destination dest = destinationRepository.findById(dto.getDestinationId()).orElse(null);
            pkg.setDestinationEntity(dest);
        }

        return toDTO(packageRepository.save(pkg));
    }

    public PackageDTO updatePackage(Long id, PackageDTO dto) {
        TravelPackage pkg = packageRepository.findById(id).orElseThrow(() -> new RuntimeException("Package not found"));
        if (dto.getName() != null) pkg.setName(dto.getName());
        if (dto.getDestination() != null) pkg.setDestination(dto.getDestination());
        if (dto.getDuration() != null) pkg.setDuration(dto.getDuration());
        if (dto.getPrice() != null) pkg.setPrice(dto.getPrice());
        if (dto.getDescription() != null) pkg.setDescription(dto.getDescription());
        if (dto.getRating() != null) pkg.setRating(dto.getRating());
        if (dto.getImage() != null) pkg.setImage(dto.getImage());
        if (dto.getItinerary() != null) pkg.setItinerary(dto.getItinerary());
        if (dto.getHotels() != null) pkg.setHotels(dto.getHotels());
        if (dto.getActivities() != null) pkg.setActivities(dto.getActivities());
        if (dto.getTransportation() != null) pkg.setTransportation(dto.getTransportation());
        if (dto.getMeals() != null) pkg.setMeals(dto.getMeals());
        if (dto.getInclusions() != null) pkg.setInclusions(dto.getInclusions());
        if (dto.getExclusions() != null) pkg.setExclusions(dto.getExclusions());
        if (dto.getFeatured() != null) pkg.setFeatured(dto.getFeatured());

        if (dto.getDestinationId() != null) {
            Destination dest = destinationRepository.findById(dto.getDestinationId()).orElse(null);
            pkg.setDestinationEntity(dest);
        }

        return toDTO(packageRepository.save(pkg));
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }

    public long getPackageCount() {
        return packageRepository.count();
    }

    private PackageDTO toDTO(TravelPackage pkg) {
        PackageDTO dto = new PackageDTO();
        dto.setId(pkg.getId());
        dto.setName(pkg.getName());
        dto.setDestination(pkg.getDestination());
        dto.setDuration(pkg.getDuration());
        dto.setPrice(pkg.getPrice());
        dto.setDescription(pkg.getDescription());
        dto.setRating(pkg.getRating());
        dto.setImage(pkg.getImage());
        dto.setItinerary(pkg.getItinerary());
        dto.setHotels(pkg.getHotels());
        dto.setActivities(pkg.getActivities());
        dto.setTransportation(pkg.getTransportation());
        dto.setMeals(pkg.getMeals());
        dto.setInclusions(pkg.getInclusions());
        dto.setExclusions(pkg.getExclusions());
        dto.setFeatured(pkg.getFeatured());
        if (pkg.getDestinationEntity() != null) {
            dto.setDestinationId(pkg.getDestinationEntity().getId());
        }
        return dto;
    }
}
