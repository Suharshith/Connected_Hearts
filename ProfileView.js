import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';

const ProfileView = () => {
  const { id } = useParams();
  const [profile, setProfile] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    loadProfile();
  }, [id]);

  const loadProfile = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/profiles/${id}`);
      setProfile(response.data);
    } catch (error) {
      setError('Profile not found');
      console.error('Error loading profile:', error);
    } finally {
      setIsLoading(false);
    }
  };

  if (isLoading) {
    return <div className="loading">Loading profile...</div>;
  }

  if (error) {
    return (
      <div className="error-page">
        <h2>Profile Not Found</h2>
        <p>{error}</p>
        <Link to="/search" className="btn btn-primary">Back to Search</Link>
      </div>
    );
  }

  return (
    <div className="profile-view">
      <div className="container">
        <Link to="/search" className="back-link">← Back to Search</Link>
        
        <div className="profile-detail">
          <div className="profile-header">
            <div className="profile-image-large">
              {profile.photoUrl ? (
                <img src={profile.photoUrl} alt={profile.name} />
              ) : (
                <div className="placeholder-image-large">📷</div>
              )}
            </div>
            
            <div className="profile-basic-info">
              <h1>{profile.name}</h1>
              <p className="age-gender">{profile.age} years old • {profile.gender}</p>
              <p className="profession">{profile.profession}</p>
              {profile.location && <p className="location">📍 {profile.location}</p>}
            </div>
          </div>
          
          <div className="profile-details">
            <div className="detail-section">
              <h3>Personal Information</h3>
              <div className="detail-grid">
                {profile.education && (
                  <div className="detail-item">
                    <strong>Education:</strong> {profile.education}
                  </div>
                )}
                {profile.religion && (
                  <div className="detail-item">
                    <strong>Religion:</strong> {profile.religion}
                  </div>
                )}
                <div className="detail-item">
                  <strong>Marital Status:</strong> {profile.maritalStatus}
                </div>
              </div>
            </div>
            
            {profile.bio && (
              <div className="detail-section">
                <h3>About</h3>
                <p className="bio">{profile.bio}</p>
              </div>
            )}
            
            <div className="detail-section">
              <h3>Contact Information</h3>
              <div className="contact-info">
                <p><strong>Phone:</strong> {profile.contactNumber}</p>
                {profile.email && <p><strong>Email:</strong> {profile.email}</p>}
              </div>
            </div>
          </div>
          
          <div className="contact-actions">
            <button className="btn btn-primary">Express Interest</button>
            <button className="btn btn-outline">Send Message</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfileView;
