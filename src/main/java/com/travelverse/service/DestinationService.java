package com.travelverse.service;

import com.travelverse.dto.DestinationDTO;
import com.travelverse.entity.Category;
import com.travelverse.entity.Destination;
import com.travelverse.repository.CategoryRepository;
import com.travelverse.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<DestinationDTO> getAllDestinations() {
        return destinationRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<DestinationDTO> getFeaturedDestinations() {
        return destinationRepository.findByFeaturedTrue().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public DestinationDTO getDestinationById(Long id) {
        Destination dest = destinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Destination not found"));
        return toDTO(dest);
    }

    public List<DestinationDTO> searchDestinations(String search) {
        return destinationRepository.searchDestinations(search).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<DestinationDTO> getByCategory(String category) {
        return destinationRepository.findByCategoryNameIgnoreCase(category).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public DestinationDTO createDestination(DestinationDTO dto) {
        Destination dest = new Destination();
        dest.setName(dto.getName());
        dest.setCountry(dto.getCountry());
        dest.setDescription(dto.getDescription());
        dest.setLongDescription(dto.getLongDescription());
        dest.setImage(dto.getImage());
        dest.setGalleryImages(dto.getGalleryImages());
        dest.setRating(dto.getRating() != null ? dto.getRating() : java.math.BigDecimal.ZERO);
        dest.setPrice(dto.getPrice());
        dest.setBestTimeToVisit(dto.getBestTimeToVisit());
        dest.setAverageBudget(dto.getAverageBudget());
        dest.setPopularAttractions(dto.getPopularAttractions());
        dest.setThingsToDo(dto.getThingsToDo());
        dest.setTravelTips(dto.getTravelTips());
        dest.setNearbyDestinations(dto.getNearbyDestinations());
        dest.setLatitude(dto.getLatitude());
        dest.setLongitude(dto.getLongitude());
        dest.setFeatured(dto.getFeatured() != null ? dto.getFeatured() : false);
        dest.setActive(dto.getActive() != null ? dto.getActive() : true);

        if (dto.getCategoryId() != null) {
            Category cat = categoryRepository.findById(dto.getCategoryId()).orElse(null);
            dest.setCategory(cat);
        }

        return toDTO(destinationRepository.save(dest));
    }

    public DestinationDTO updateDestination(Long id, DestinationDTO dto) {
        Destination dest = destinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Destination not found"));
        if (dto.getName() != null) dest.setName(dto.getName());
        if (dto.getCountry() != null) dest.setCountry(dto.getCountry());
        if (dto.getDescription() != null) dest.setDescription(dto.getDescription());
        if (dto.getLongDescription() != null) dest.setLongDescription(dto.getLongDescription());
        if (dto.getImage() != null) dest.setImage(dto.getImage());
        if (dto.getGalleryImages() != null) dest.setGalleryImages(dto.getGalleryImages());
        if (dto.getRating() != null) dest.setRating(dto.getRating());
        if (dto.getPrice() != null) dest.setPrice(dto.getPrice());
        if (dto.getBestTimeToVisit() != null) dest.setBestTimeToVisit(dto.getBestTimeToVisit());
        if (dto.getAverageBudget() != null) dest.setAverageBudget(dto.getAverageBudget());
        if (dto.getPopularAttractions() != null) dest.setPopularAttractions(dto.getPopularAttractions());
        if (dto.getThingsToDo() != null) dest.setThingsToDo(dto.getThingsToDo());
        if (dto.getTravelTips() != null) dest.setTravelTips(dto.getTravelTips());
        if (dto.getNearbyDestinations() != null) dest.setNearbyDestinations(dto.getNearbyDestinations());
        if (dto.getLatitude() != null) dest.setLatitude(dto.getLatitude());
        if (dto.getLongitude() != null) dest.setLongitude(dto.getLongitude());
        if (dto.getFeatured() != null) dest.setFeatured(dto.getFeatured());
        if (dto.getActive() != null) dest.setActive(dto.getActive());

        if (dto.getCategoryId() != null) {
            Category cat = categoryRepository.findById(dto.getCategoryId()).orElse(null);
            dest.setCategory(cat);
        }

        return toDTO(destinationRepository.save(dest));
    }

    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }

    public long getDestinationCount() {
        return destinationRepository.count();
    }

    private DestinationDTO toDTO(Destination dest) {
        DestinationDTO dto = new DestinationDTO();
        dto.setId(dest.getId());
        dto.setName(dest.getName());
        dto.setCountry(dest.getCountry());
        dto.setDescription(dest.getDescription());
        dto.setLongDescription(dest.getLongDescription());
        dto.setImage(dest.getImage());
        dto.setGalleryImages(dest.getGalleryImages());
        dto.setRating(dest.getRating());
        dto.setPrice(dest.getPrice());
        dto.setBestTimeToVisit(dest.getBestTimeToVisit());
        dto.setAverageBudget(dest.getAverageBudget());
        dto.setPopularAttractions(dest.getPopularAttractions());
        dto.setThingsToDo(dest.getThingsToDo());
        dto.setTravelTips(dest.getTravelTips());
        dto.setNearbyDestinations(dest.getNearbyDestinations());
        dto.setLatitude(dest.getLatitude());
        dto.setLongitude(dest.getLongitude());
        dto.setFeatured(dest.getFeatured());
        dto.setActive(dest.getActive());
        if (dest.getCategory() != null) {
            dto.setCategoryId(dest.getCategory().getId());
            dto.setCategoryName(dest.getCategory().getName());
        }
        return dto;
    }
}
