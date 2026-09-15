package com.travelverse.repository;

import com.travelverse.entity.Favorite;
import com.travelverse.entity.Favorite.FavoriteType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
    List<Favorite> findByUserIdAndType(Long userId, FavoriteType type);
    Optional<Favorite> findByUserIdAndTypeAndItemId(Long userId, FavoriteType type, Long itemId);
    void deleteByUserIdAndTypeAndItemId(Long userId, FavoriteType type, Long itemId);
}
