package com.travelverse.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FavoriteType type;

    private Long itemId;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum FavoriteType {
        DESTINATION, PACKAGE, EXPERIENCE
    }

    public Favorite() {}

    public Favorite(User user, FavoriteType type, Long itemId) {
        this.user = user;
        this.type = type;
        this.itemId = itemId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public FavoriteType getType() { return type; }
    public void setType(FavoriteType type) { this.type = type; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
