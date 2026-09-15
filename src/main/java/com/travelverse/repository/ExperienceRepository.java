package com.travelverse.repository;

import com.travelverse.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByFeaturedTrue();
    List<Experience> findByDestinationContainingIgnoreCase(String destination);
}
