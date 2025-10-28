
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Home from './components/Home';
import Register from './components/Register';
import Search from './components/Search';
import ProfileView from './components/ProfileView';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
      
        <Header />
        <main className="main-content">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<Register />} />
            <Route path="/search" element={<Search />} />
            <Route path="/profile/:id" element={<ProfileView />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
