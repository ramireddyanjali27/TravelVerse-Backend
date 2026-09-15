package com.travelverse.service;

import com.travelverse.dto.UserDTO;
import com.travelverse.entity.User;
import com.travelverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (dto.getName() != null) user.setName(dto.getName());
        if (dto.getPhone() != null) user.setPhone(dto.getPhone());
        if (dto.getCountry() != null) user.setCountry(dto.getCountry());
        if (dto.getProfileImage() != null) user.setProfileImage(dto.getProfileImage());
        if (dto.getPreferredTravelStyle() != null) user.setPreferredTravelStyle(dto.getPreferredTravelStyle());
        return toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public long getUserCount() {
        return userRepository.count();
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setCountry(user.getCountry());
        dto.setProfileImage(user.getProfileImage());
        dto.setPreferredTravelStyle(user.getPreferredTravelStyle());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
