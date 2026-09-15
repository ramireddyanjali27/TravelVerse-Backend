package com.travelverse.service;

import com.travelverse.dto.FavoriteDTO;
import com.travelverse.entity.*;
import com.travelverse.entity.Favorite.FavoriteType;
import com.travelverse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private TravelPackageRepository packageRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<FavoriteDTO> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FavoriteDTO addFavorite(FavoriteDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        FavoriteType type = FavoriteType.valueOf(dto.getType());

        // Check if already exists
        var existing = favoriteRepository.findByUserIdAndTypeAndItemId(user.getId(), type, dto.getItemId());
        if (existing.isPresent()) {
            throw new RuntimeException("Already in favorites");
        }

        Favorite fav = new Favorite(user, type, dto.getItemId());
        return toDTO(favoriteRepository.save(fav));
    }

    public void removeFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    private FavoriteDTO toDTO(Favorite fav) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(fav.getId());
        dto.setUserId(fav.getUser().getId());
        dto.setType(fav.getType().name());
        dto.setItemId(fav.getItemId());
        dto.setCreatedAt(fav.getCreatedAt().toString());

        // Populate item details
        try {
            switch (fav.getType()) {
                case DESTINATION -> {
                    var dest = destinationRepository.findById(fav.getItemId()).orElse(null);
                    if (dest != null) {
                        dto.setItemName(dest.getName());
                        dto.setItemImage(dest.getImage());
                        dto.setItemDescription(dest.getDescription());
                    }
                }
                case PACKAGE -> {
                    var pkg = packageRepository.findById(fav.getItemId()).orElse(null);
                    if (pkg != null) {
                        dto.setItemName(pkg.getName());
                        dto.setItemImage(pkg.getImage());
                        dto.setItemDescription(pkg.getDescription());
                    }
                }
                case EXPERIENCE -> {
                    var exp = experienceRepository.findById(fav.getItemId()).orElse(null);
                    if (exp != null) {
                        dto.setItemName(exp.getName());
                        dto.setItemImage(exp.getImage());
                        dto.setItemDescription(exp.getDescription());
                    }
                }
            }
        } catch (Exception ignored) {}

        return dto;
    }
}
