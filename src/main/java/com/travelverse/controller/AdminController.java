package com.travelverse.controller;

import com.travelverse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private PackageService packageService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", userService.getUserCount());
        stats.put("totalDestinations", destinationService.getDestinationCount());
        stats.put("totalPackages", packageService.getPackageCount());
        stats.put("totalBookings", bookingService.getBookingCount());
        stats.put("confirmedBookings", bookingService.getBookingCountByStatus(
                com.travelverse.entity.Booking.BookingStatus.CONFIRMED));
        stats.put("pendingBookings", bookingService.getBookingCountByStatus(
                com.travelverse.entity.Booking.BookingStatus.PENDING));
        return ResponseEntity.ok(stats);
    }
}
