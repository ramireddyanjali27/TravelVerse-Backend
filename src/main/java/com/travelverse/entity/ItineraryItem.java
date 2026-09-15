package com.travelverse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "itinerary_items")
public class ItineraryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    private Integer dayNumber;
    private String title;
    private String description;
    private String location;
    private String activity;
    private String time;
    private String category;

    public ItineraryItem() {}

    public ItineraryItem(Trip trip, Integer dayNumber, String title, String description) {
        this.trip = trip;
        this.dayNumber = dayNumber;
        this.title = title;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Trip getTrip() { return trip; }
    public void setTrip(Trip trip) { this.trip = trip; }
    public Integer getDayNumber() { return dayNumber; }
    public void setDayNumber(Integer dayNumber) { this.dayNumber = dayNumber; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
