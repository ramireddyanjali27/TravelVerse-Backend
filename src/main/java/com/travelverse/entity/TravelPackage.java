package com.travelverse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "travel_packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id")
    private Destination destinationEntity;

    @Column(nullable = false)
    private String duration; // e.g., "5 Days / 4 Nights"

    @Column(nullable = false)
    private BigDecimal price;

    @Column(length = 2000)
    private String description;

    private BigDecimal rating = BigDecimal.ZERO;

    private String image;
    private String itinerary; // JSON - day by day
    private String hotels; // JSON
    private String activities; // JSON
    private String transportation; // JSON
    private String meals; // JSON
    private String inclusions; // JSON array
    private String exclusions; // JSON array

    private Boolean featured = false;
    private Boolean active = true;

    public TravelPackage() {}

    public TravelPackage(String name, String destination, String duration, BigDecimal price, String description, BigDecimal rating, String image) {
        this.name = name;
        this.destination = destination;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Destination getDestinationEntity() { return destinationEntity; }
    public void setDestinationEntity(Destination destinationEntity) { this.destinationEntity = destinationEntity; }

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

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
