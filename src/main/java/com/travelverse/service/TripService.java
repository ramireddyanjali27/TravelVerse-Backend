package com.travelverse.service;

import com.travelverse.dto.ItineraryItemDTO;
import com.travelverse.dto.TripDTO;
import com.travelverse.entity.ItineraryItem;
import com.travelverse.entity.Trip;
import com.travelverse.entity.User;
import com.travelverse.repository.ItineraryItemRepository;
import com.travelverse.repository.TripRepository;
import com.travelverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ItineraryItemRepository itineraryItemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TripDTO> getTripsByUserId(Long userId) {
        return tripRepository.findByUserIdOrderByCreatedAtDesc(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TripDTO getTripById(Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        return toDTO(trip);
    }

    public TripDTO createTrip(TripDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        Trip trip = new Trip();
        trip.setUser(user);
        trip.setTripName(dto.getTripName());
        trip.setDestination(dto.getDestination());
        trip.setStartDate(dto.getStartDate());
        trip.setEndDate(dto.getEndDate());
        trip.setNumberOfTravelers(dto.getNumberOfTravelers() != null ? dto.getNumberOfTravelers() : 1);
        trip.setBudget(dto.getBudget());
        trip.setTravelType(dto.getTravelType());

        Trip saved = tripRepository.save(trip);

        // Add itinerary items if present
        if (dto.getItineraryItems() != null) {
            for (ItineraryItemDTO itemDTO : dto.getItineraryItems()) {
                ItineraryItem item = new ItineraryItem();
                item.setTrip(saved);
                item.setDayNumber(itemDTO.getDayNumber());
                item.setTitle(itemDTO.getTitle());
                item.setDescription(itemDTO.getDescription());
                item.setLocation(itemDTO.getLocation());
                item.setActivity(itemDTO.getActivity());
                item.setTime(itemDTO.getTime());
                item.setCategory(itemDTO.getCategory());
                itineraryItemRepository.save(item);
            }
        }

        return getTripById(saved.getId());
    }

    public TripDTO updateTrip(Long id, TripDTO dto) {
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        if (dto.getTripName() != null) trip.setTripName(dto.getTripName());
        if (dto.getDestination() != null) trip.setDestination(dto.getDestination());
        if (dto.getStartDate() != null) trip.setStartDate(dto.getStartDate());
        if (dto.getEndDate() != null) trip.setEndDate(dto.getEndDate());
        if (dto.getNumberOfTravelers() != null) trip.setNumberOfTravelers(dto.getNumberOfTravelers());
        if (dto.getBudget() != null) trip.setBudget(dto.getBudget());
        if (dto.getTravelType() != null) trip.setTravelType(dto.getTravelType());
        tripRepository.save(trip);
        return getTripById(id);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // Itinerary methods
    public List<ItineraryItemDTO> getItineraryItems(Long tripId) {
        return itineraryItemRepository.findByTripIdOrderByDayNumber(tripId).stream().map(this::toItemDTO).collect(Collectors.toList());
    }

    public ItineraryItemDTO addItineraryItem(Long tripId, ItineraryItemDTO dto) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new RuntimeException("Trip not found"));
        ItineraryItem item = new ItineraryItem();
        item.setTrip(trip);
        item.setDayNumber(dto.getDayNumber());
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setLocation(dto.getLocation());
        item.setActivity(dto.getActivity());
        item.setTime(dto.getTime());
        item.setCategory(dto.getCategory());
        return toItemDTO(itineraryItemRepository.save(item));
    }

    public ItineraryItemDTO updateItineraryItem(Long id, ItineraryItemDTO dto) {
        ItineraryItem item = itineraryItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        if (dto.getDayNumber() != null) item.setDayNumber(dto.getDayNumber());
        if (dto.getTitle() != null) item.setTitle(dto.getTitle());
        if (dto.getDescription() != null) item.setDescription(dto.getDescription());
        if (dto.getLocation() != null) item.setLocation(dto.getLocation());
        if (dto.getActivity() != null) item.setActivity(dto.getActivity());
        if (dto.getTime() != null) item.setTime(dto.getTime());
        if (dto.getCategory() != null) item.setCategory(dto.getCategory());
        return toItemDTO(itineraryItemRepository.save(item));
    }

    public void deleteItineraryItem(Long id) {
        itineraryItemRepository.deleteById(id);
    }

    private TripDTO toDTO(Trip trip) {
        TripDTO dto = new TripDTO();
        dto.setId(trip.getId());
        dto.setUserId(trip.getUser().getId());
        dto.setTripName(trip.getTripName());
        dto.setDestination(trip.getDestination());
        dto.setStartDate(trip.getStartDate());
        dto.setEndDate(trip.getEndDate());
        dto.setNumberOfTravelers(trip.getNumberOfTravelers());
        dto.setBudget(trip.getBudget());
        dto.setTravelType(trip.getTravelType());
        List<ItineraryItem> items = itineraryItemRepository.findByTripIdOrderByDayNumber(trip.getId());
        dto.setItineraryItems(items.stream().map(this::toItemDTO).collect(Collectors.toList()));
        return dto;
    }

    private ItineraryItemDTO toItemDTO(ItineraryItem item) {
        ItineraryItemDTO dto = new ItineraryItemDTO();
        dto.setId(item.getId());
        dto.setTripId(item.getTrip().getId());
        dto.setDayNumber(item.getDayNumber());
        dto.setTitle(item.getTitle());
        dto.setDescription(item.getDescription());
        dto.setLocation(item.getLocation());
        dto.setActivity(item.getActivity());
        dto.setTime(item.getTime());
        dto.setCategory(item.getCategory());
        return dto;
    }
}
