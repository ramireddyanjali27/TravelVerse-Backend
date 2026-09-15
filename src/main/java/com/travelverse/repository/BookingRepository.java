package com.travelverse.repository;

import com.travelverse.entity.Booking;
import com.travelverse.entity.Booking.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<Booking> findByStatus(BookingStatus status);
    long countByStatus(BookingStatus status);
}
