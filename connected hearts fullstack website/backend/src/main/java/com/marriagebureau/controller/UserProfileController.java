package com.marriagebureau.controller;

import com.marriagebureau.model.UserProfile;
import com.marriagebureau.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "http://localhost:3000")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // Get all profiles
    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    // Get profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getProfileById(@PathVariable String id) {
        Optional<UserProfile> profile = userProfileRepository.findById(id);
        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Create new profile
    @PostMapping
    public ResponseEntity<UserProfile> createProfile(@Valid @RequestBody UserProfile userProfile) {
        try {
            UserProfile savedProfile = userProfileRepository.save(userProfile);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Update profile
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable String id, 
                                                     @Valid @RequestBody UserProfile userProfile) {
        Optional<UserProfile> existingProfile = userProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            userProfile.setId(id);
            UserProfile updatedProfile = userProfileRepository.save(userProfile);
            return ResponseEntity.ok(updatedProfile);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable String id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search profiles by gender
    @GetMapping("/search/gender/{gender}")
    public List<UserProfile> getProfilesByGender(@PathVariable String gender) {
        return userProfileRepository.findByGender(gender);
    }

    // Search profiles by age range
    @GetMapping("/search/age")
    public List<UserProfile> getProfilesByAgeRange(@RequestParam Integer minAge, 
                                                   @RequestParam Integer maxAge) {
        return userProfileRepository.findByAgeBetween(minAge, maxAge);
    }

    // Search profiles by location
    @GetMapping("/search/location/{location}")
    public List<UserProfile> getProfilesByLocation(@PathVariable String location) {
        return userProfileRepository.findByLocationContainingIgnoreCase(location);
    }

    // Search profiles by profession
    @GetMapping("/search/profession/{profession}")
    public List<UserProfile> getProfilesByProfession(@PathVariable String profession) {
        return userProfileRepository.findByProfessionContainingIgnoreCase(profession);
    }

    // Advanced search with multiple criteria
    @GetMapping("/search")
    public List<UserProfile> searchProfiles(@RequestParam(required = false) String gender,
                                           @RequestParam(required = false) Integer minAge,
                                           @RequestParam(required = false) Integer maxAge,
                                           @RequestParam(required = false) String location,
                                           @RequestParam(required = false) String profession,
                                           @RequestParam(required = false) String religion) {
        
        if (gender != null && minAge != null && maxAge != null) {
            return userProfileRepository.findByGenderAndAgeRange(gender, minAge, maxAge);
        } else if (gender != null) {
            return userProfileRepository.findByGender(gender);
        } else if (minAge != null && maxAge != null) {
            return userProfileRepository.findByAgeBetween(minAge, maxAge);
        } else if (location != null) {
            return userProfileRepository.findByLocationContainingIgnoreCase(location);
        } else if (profession != null) {
            return userProfileRepository.findByProfessionContainingIgnoreCase(profession);
        } else if (religion != null) {
            return userProfileRepository.findByReligionContainingIgnoreCase(religion);
        }
        
        return userProfileRepository.findAll();
    }
}
