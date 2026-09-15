package com.travelverse.repository;

import com.travelverse.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByFeaturedTrue();
    List<Destination> findByActiveTrue();
    List<Destination> findByCountryContainingIgnoreCase(String country);
    List<Destination> findByNameContainingIgnoreCase(String name);

    @Query("SELECT d FROM Destination d WHERE d.active = true AND " +
           "(LOWER(d.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(d.country) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Destination> searchDestinations(String search);

    List<Destination> findByCategoryNameIgnoreCase(String category);
}
