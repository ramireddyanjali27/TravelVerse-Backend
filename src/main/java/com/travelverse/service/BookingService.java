package com.travelverse.service;

import com.travelverse.dto.BookingDTO;
import com.travelverse.entity.Booking;
import com.travelverse.entity.Booking.BookingStatus;
import com.travelverse.entity.Destination;
import com.travelverse.entity.TravelPackage;
import com.travelverse.entity.User;
import com.travelverse.repository.BookingRepository;
import com.travelverse.repository.DestinationRepository;
import com.travelverse.repository.TravelPackageRepository;
import com.travelverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravelPackageRepository packageRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserIdOrderByCreatedAtDesc(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return toDTO(booking);
    }

    public BookingDTO createBooking(BookingDTO dto) {
        Booking booking = new Booking();

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);

        if (dto.getPackageId() != null) {
            TravelPackage pkg = packageRepository.findById(dto.getPackageId()).orElse(null);
            booking.setTravelPackage(pkg);
        }

        if (dto.getDestinationId() != null) {
            Destination dest = destinationRepository.findById(dto.getDestinationId()).orElse(null);
            booking.setDestination(dest);
        }

        booking.setTravelDate(dto.getTravelDate() != null ? dto.getTravelDate() : LocalDate.now().plusDays(7));
        booking.setNumberOfTravelers(dto.getNumberOfTravelers() != null ? dto.getNumberOfTravelers() : 1);
        booking.setTotalAmount(dto.getTotalAmount() != null ? dto.getTotalAmount() : BigDecimal.ZERO);
        booking.setStatus(BookingStatus.PENDING);

        return toDTO(bookingRepository.save(booking));
    }

    public BookingDTO updateBooking(Long id, BookingDTO dto) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        if (dto.getStatus() != null) booking.setStatus(BookingStatus.valueOf(dto.getStatus()));
        if (dto.getTravelDate() != null) booking.setTravelDate(dto.getTravelDate());
        if (dto.getNumberOfTravelers() != null) booking.setNumberOfTravelers(dto.getNumberOfTravelers());
        if (dto.getTotalAmount() != null) booking.setTotalAmount(dto.getTotalAmount());
        return toDTO(bookingRepository.save(booking));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public long getBookingCount() {
        return bookingRepository.count();
    }

    public long getBookingCountByStatus(BookingStatus status) {
        return bookingRepository.countByStatus(status);
    }

    private BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUser().getId());
        dto.setUserName(booking.getUser().getName());
        if (booking.getTravelPackage() != null) {
            dto.setPackageId(booking.getTravelPackage().getId());
            dto.setPackageName(booking.getTravelPackage().getName());
        }
        if (booking.getDestination() != null) {
            dto.setDestinationId(booking.getDestination().getId());
            dto.setDestinationName(booking.getDestination().getName());
        }
        dto.setTravelDate(booking.getTravelDate());
        dto.setNumberOfTravelers(booking.getNumberOfTravelers());
        dto.setTotalAmount(booking.getTotalAmount());
        dto.setStatus(booking.getStatus().name());
        dto.setCreatedAt(booking.getCreatedAt().toString());
        return dto;
    }
}
