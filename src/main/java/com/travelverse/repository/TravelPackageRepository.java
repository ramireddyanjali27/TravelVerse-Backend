package com.travelverse.repository;

import com.travelverse.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    List<TravelPackage> findByFeaturedTrue();
    List<TravelPackage> findByActiveTrue();
    List<TravelPackage> findByDestinationContainingIgnoreCase(String destination);
}
