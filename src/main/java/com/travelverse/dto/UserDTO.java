package com.travelverse.dto;

import java.math.BigDecimal;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String profileImage;
    private String preferredTravelStyle;
    private String role;

    public UserDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
    public String getPreferredTravelStyle() { return preferredTravelStyle; }
    public void setPreferredTravelStyle(String preferredTravelStyle) { this.preferredTravelStyle = preferredTravelStyle; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
