package com.travelverse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String longDescription;

    private String image;
    private String galleryImages; // JSON array of URLs

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal rating = BigDecimal.ZERO;
    private BigDecimal price;
    private String bestTimeToVisit;
    private String averageBudget;
    private String popularAttractions; // JSON array
    private String thingsToDo; // JSON array
    private String travelTips; // JSON array
    private String nearbyDestinations; // JSON array
    private String latitude;
    private String longitude;

    private Boolean featured = false;
    private Boolean active = true;

    // Constructors
    public Destination() {}

    public Destination(String name, String country, String description, String image, BigDecimal rating, BigDecimal price) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getGalleryImages() { return galleryImages; }
    public void setGalleryImages(String galleryImages) { this.galleryImages = galleryImages; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getBestTimeToVisit() { return bestTimeToVisit; }
    public void setBestTimeToVisit(String bestTimeToVisit) { this.bestTimeToVisit = bestTimeToVisit; }

    public String getAverageBudget() { return averageBudget; }
    public void setAverageBudget(String averageBudget) { this.averageBudget = averageBudget; }

    public String getPopularAttractions() { return popularAttractions; }
    public void setPopularAttractions(String popularAttractions) { this.popularAttractions = popularAttractions; }

    public String getThingsToDo() { return thingsToDo; }
    public void setThingsToDo(String thingsToDo) { this.thingsToDo = thingsToDo; }

    public String getTravelTips() { return travelTips; }
    public void setTravelTips(String travelTips) { this.travelTips = travelTips; }

    public String getNearbyDestinations() { return nearbyDestinations; }
    public void setNearbyDestinations(String nearbyDestinations) { this.nearbyDestinations = nearbyDestinations; }

    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
