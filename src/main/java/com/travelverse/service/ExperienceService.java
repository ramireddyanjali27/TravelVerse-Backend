package com.travelverse.service;

import com.travelverse.entity.Experience;
import com.travelverse.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public List<Experience> getFeaturedExperiences() {
        return experienceRepository.findByFeaturedTrue();
    }

    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(Long id, Experience updated) {
        Experience exp = experienceRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));
        exp.setName(updated.getName());
        exp.setDestination(updated.getDestination());
        exp.setCategory(updated.getCategory());
        exp.setDescription(updated.getDescription());
        exp.setImage(updated.getImage());
        exp.setPrice(updated.getPrice());
        exp.setRating(updated.getRating());
        exp.setDuration(updated.getDuration());
        exp.setIncluded(updated.getIncluded());
        exp.setFeatured(updated.getFeatured());
        return experienceRepository.save(exp);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
