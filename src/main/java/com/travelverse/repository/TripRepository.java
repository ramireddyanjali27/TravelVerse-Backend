package com.travelverse.repository;

import com.travelverse.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUserId(Long userId);
    List<Trip> findByUserIdOrderByCreatedAtDesc(Long userId);
}
