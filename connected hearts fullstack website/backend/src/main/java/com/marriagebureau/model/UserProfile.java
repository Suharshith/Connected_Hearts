package com.marriagebureau.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Document(collection = "user_profiles")
public class UserProfile {
    
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 80, message = "Age must be less than 80")
    private Integer age;
    
    @NotBlank(message = "Gender is required")
    private String gender;
    
    @NotBlank(message = "Profession is required")
    private String profession;
    
    private String education;
    
    private String location;
    
    private String religion;
    
    private String maritalStatus;
    
    @NotBlank(message = "Contact number is required")
    private String contactNumber;
    
    private String email;
    
    private String bio;
    
    private String photoUrl;
    
    // Constructors
    public UserProfile() {}
    
    public UserProfile(String name, Integer age, String gender, String profession, 
                      String education, String location, String religion, 
                      String maritalStatus, String contactNumber, String email, 
                      String bio, String photoUrl) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.education = education;
        this.location = location;
        this.religion = religion;
        this.maritalStatus = maritalStatus;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bio = bio;
        this.photoUrl = photoUrl;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getProfession() {
        return profession;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String getEducation() {
        return education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getReligion() {
        return religion;
    }
    
    public void setReligion(String religion) {
        this.religion = religion;
    }
    
    public String getMaritalStatus() {
        return maritalStatus;
    }
    
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public String getPhotoUrl() {
        return photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
