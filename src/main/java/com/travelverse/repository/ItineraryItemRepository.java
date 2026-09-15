package com.travelverse.repository;

import com.travelverse.entity.ItineraryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItineraryItemRepository extends JpaRepository<ItineraryItem, Long> {
    List<ItineraryItem> findByTripIdOrderByDayNumber(Long tripId);
}
