import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Search = () => {
  const [profiles, setProfiles] = useState([]);
  const [searchCriteria, setSearchCriteria] = useState({
    gender: '',
    minAge: '',
    maxAge: '',
    location: '',
    profession: '',
    religion: ''
  });
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    loadAllProfiles();
  }, []);

  const loadAllProfiles = async () => {
    setIsLoading(true);
    try {
      const response = await axios.get('http://localhost:8080/api/profiles');
      setProfiles(response.data);
    } catch (error) {
      console.error('Error loading profiles:', error);
    } finally {
      setIsLoading(false);
    }
  };

  const handleSearchChange = (e) => {
    setSearchCriteria({
      ...searchCriteria,
      [e.target.name]: e.target.value
    });
  };

  const handleSearch = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    
    try {
      const params = new URLSearchParams();
      Object.keys(searchCriteria).forEach(key => {
        if (searchCriteria[key]) {
          params.append(key, searchCriteria[key]);
        }
      });
      
      const response = await axios.get(`http://localhost:8080/api/profiles/search?${params}`);
      setProfiles(response.data);
    } catch (error) {
      console.error('Error searching profiles:', error);
    } finally {
      setIsLoading(false);
    }
  };

  const clearSearch = () => {
    setSearchCriteria({
      gender: '',
      minAge: '',
      maxAge: '',
      location: '',
      profession: '',
      religion: ''
    });
    loadAllProfiles();
  };

  return (
    <div className="search">
      <div className="container">
        <h2>Search Profiles</h2>
        
        <div className="search-form">
          <form onSubmit={handleSearch}>
            <div className="form-row">
              <div className="form-group">
                <label htmlFor="gender">Gender</label>
                <select
                  id="gender"
                  name="gender"
                  value={searchCriteria.gender}
                  onChange={handleSearchChange}
                >
                  <option value="">Any</option>
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                </select>
              </div>
              
              <div className="form-group">
                <label htmlFor="minAge">Min Age</label>
                <input
                  type="number"
                  id="minAge"
                  name="minAge"
                  value={searchCriteria.minAge}
                  onChange={handleSearchChange}
                  min="18"
                />
              </div>
              
              <div className="form-group">
                <label htmlFor="maxAge">Max Age</label>
                <input
                  type="number"
                  id="maxAge"
                  name="maxAge"
                  value={searchCriteria.maxAge}
                  onChange={handleSearchChange}
                  max="80"
                />
              </div>
            </div>
            
            <div className="form-row">
              <div className="form-group">
                <label htmlFor="location">Location</label>
                <input
                  type="text"
                  id="location"
                  name="location"
                  value={searchCriteria.location}
                  onChange={handleSearchChange}
                />
              </div>
              
              <div className="form-group">
                <label htmlFor="profession">Profession</label>
                <input
                  type="text"
                  id="profession"
                  name="profession"
                  value={searchCriteria.profession}
                  onChange={handleSearchChange}
                />
              </div>
              
              <div className="form-group">
                <label htmlFor="religion">Religion</label>
                <input
                  type="text"
                  id="religion"
                  name="religion"
                  value={searchCriteria.religion}
                  onChange={handleSearchChange}
                />
              </div>
            </div>
            
            <div className="search-buttons">
              <button type="submit" className="btn btn-primary" disabled={isLoading}>
                {isLoading ? 'Searching...' : 'Search'}
              </button>
              <button type="button" onClick={clearSearch} className="btn btn-secondary">
                Clear
              </button>
            </div>
          </form>
        </div>
        
        <div className="profiles-grid">
          {profiles.length === 0 && !isLoading && (
            <p className="no-results">No profiles found.</p>
          )}
          
          {profiles.map(profile => (
            <div key={profile.id} className="profile-card">
              <div className="profile-image">
                {profile.photoUrl ? (
                  <img src={profile.photoUrl} alt={profile.name} />
                ) : (
                  <div className="placeholder-image">📷</div>
                )}
              </div>
              
              <div className="profile-info">
                <h3>{profile.name}</h3>
                <p><strong>Age:</strong> {profile.age}</p>
                <p><strong>Profession:</strong> {profile.profession}</p>
                {profile.location && <p><strong>Location:</strong> {profile.location}</p>}
                {profile.education && <p><strong>Education:</strong> {profile.education}</p>}
                
                <Link to={`/profile/${profile.id}`} className="btn btn-outline">
                  View Profile
                </Link>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Search;
