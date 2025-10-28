package com.marriagebureau.repository;

import com.marriagebureau.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    
    // Find profiles by gender
    List<UserProfile> findByGender(String gender);
    
    // Find profiles by age range
    List<UserProfile> findByAgeBetween(Integer minAge, Integer maxAge);
    
    // Find profiles by location
    List<UserProfile> findByLocationContainingIgnoreCase(String location);
    
    // Find profiles by profession
    List<UserProfile> findByProfessionContainingIgnoreCase(String profession);
    
    // Find profiles by religion
    List<UserProfile> findByReligionContainingIgnoreCase(String religion);
    
    // Custom query for search with multiple criteria
    @Query("{'gender': ?0, 'age': {$gte: ?1, $lte: ?2}}")
    List<UserProfile> findByGenderAndAgeRange(String gender, Integer minAge, Integer maxAge);
}
