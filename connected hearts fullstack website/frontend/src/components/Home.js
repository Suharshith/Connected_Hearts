import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div className="home">
      <div className="hero-section">
        <h2>Find Your Perfect Life Partner</h2>
        <p>Join thousands of people who have found their soulmate through our platform</p>
        <div className="cta-buttons">
          <Link to="/register" className="btn btn-primary">Register Now</Link>
          <Link to="/search" className="btn btn-secondary">Browse Profiles</Link>
        </div>
      </div>
      
      <div className="features">
        <div className="feature-card">
          <h3>🔍 Advanced Search</h3>
          <p>Find matches based on age, location, profession, and more</p>
        </div>
        <div className="feature-card">
          <h3>📝 Detailed Profiles</h3>
          <p>Create comprehensive profiles with all necessary information</p>
        </div>
        <div className="feature-card">
          <h3>🔒 Safe & Secure</h3>
          <p>Your privacy and security are our top priorities</p>
        </div>
      </div>
    </div>
  );
};

export default Home;
