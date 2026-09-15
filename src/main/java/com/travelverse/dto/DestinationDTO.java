package com.travelverse.dto;

import java.math.BigDecimal;

public class DestinationDTO {
    private Long id;
    private String name;
    private String country;
    private String description;
    private String longDescription;
    private String image;
    private String galleryImages;
    private Long categoryId;
    private String categoryName;
    private BigDecimal rating;
    private BigDecimal price;
    private String bestTimeToVisit;
    private String averageBudget;
    private String popularAttractions;
    private String thingsToDo;
    private String travelTips;
    private String nearbyDestinations;
    private String latitude;
    private String longitude;
    private Boolean featured;
    private Boolean active;

    public DestinationDTO() {}

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
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
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
