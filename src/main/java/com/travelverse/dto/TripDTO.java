package com.travelverse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TripDTO {
    private Long id;
    private Long userId;
    private String tripName;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfTravelers;
    private BigDecimal budget;
    private String travelType;
    private List<ItineraryItemDTO> itineraryItems;

    public TripDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getTripName() { return tripName; }
    public void setTripName(String tripName) { this.tripName = tripName; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public Integer getNumberOfTravelers() { return numberOfTravelers; }
    public void setNumberOfTravelers(Integer numberOfTravelers) { this.numberOfTravelers = numberOfTravelers; }
    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
    public String getTravelType() { return travelType; }
    public void setTravelType(String travelType) { this.travelType = travelType; }
    public List<ItineraryItemDTO> getItineraryItems() { return itineraryItems; }
    public void setItineraryItems(List<ItineraryItemDTO> itineraryItems) { this.itineraryItems = itineraryItems; }
}
