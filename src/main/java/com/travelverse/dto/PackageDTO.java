package com.travelverse.dto;

import java.math.BigDecimal;

public class PackageDTO {
    private Long id;
    private String name;
    private String destination;
    private Long destinationId;
    private String duration;
    private BigDecimal price;
    private String description;
    private BigDecimal rating;
    private String image;
    private String itinerary;
    private String hotels;
    private String activities;
    private String transportation;
    private String meals;
    private String inclusions;
    private String exclusions;
    private Boolean featured;

    public PackageDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public Long getDestinationId() { return destinationId; }
    public void setDestinationId(Long destinationId) { this.destinationId = destinationId; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getItinerary() { return itinerary; }
    public void setItinerary(String itinerary) { this.itinerary = itinerary; }
    public String getHotels() { return hotels; }
    public void setHotels(String hotels) { this.hotels = hotels; }
    public String getActivities() { return activities; }
    public void setActivities(String activities) { this.activities = activities; }
    public String getTransportation() { return transportation; }
    public void setTransportation(String transportation) { this.transportation = transportation; }
    public String getMeals() { return meals; }
    public void setMeals(String meals) { this.meals = meals; }
    public String getInclusions() { return inclusions; }
    public void setInclusions(String inclusions) { this.inclusions = inclusions; }
    public String getExclusions() { return exclusions; }
    public void setExclusions(String exclusions) { this.exclusions = exclusions; }
    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }
}
