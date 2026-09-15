package com.travelverse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String destination;
    private String category;
    private String description;
    private String image;
    private BigDecimal price;
    private BigDecimal rating;
    private String duration;
    private String included;
    private Boolean featured = false;

    public Experience() {}

    public Experience(String name, String destination, String category, String description, String image, BigDecimal price, BigDecimal rating, String duration) {
        this.name = name;
        this.destination = destination;
        this.category = category;
        this.description = description;
        this.image = image;
        this.price = price;
        this.rating = rating;
        this.duration = duration;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getIncluded() { return included; }
    public void setIncluded(String included) { this.included = included; }
    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }
}
