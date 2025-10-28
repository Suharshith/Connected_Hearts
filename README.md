# Marriage Bureau Fullstack Website

A complete marriage bureau website built with React frontend and Spring Boot backend, using MongoDB for data storage.

## Features

- 👥 User Profile Registration
- 🔍 Advanced Search and Filtering
- 📱 Responsive Design
- 🔒 Data Validation
- 📊 Profile Management

## Technology Stack

### Frontend
- **React.js** - Modern JavaScript library for building user interfaces
- **HTML5 & CSS3** - Semantic markup and responsive styling
- **JavaScript (ES6+)** - Interactive functionality
- **Axios** - HTTP client for API communication
- **React Router** - Client-side routing

### Backend
- **Spring Boot** - Java framework for building REST APIs
- **Spring Data MongoDB** - Database integration
- **Maven** - Dependency management and build tool

### Database
- **MongoDB** - NoSQL database for storing user profiles

## Project Structure

```
marriage-bureau/
├── frontend/          # React frontend application
│   ├── public/       # Static assets
│   ├── src/          # Source code
│   │   ├── components/  # React components
│   │   ├── App.js      # Main App component
│   │   ├── App.css     # Styling
│   │   └── index.js    # Entry point
│   └── package.json   # Frontend dependencies
├── backend/           # Spring Boot backend
│   ├── src/main/java/ # Java source code
│   │   └── com/marriagebureau/
│   │       ├── model/      # Data models
│   │       ├── repository/ # Data repositories
│   │       └── controller/ # REST controllers
│   └── pom.xml        # Backend dependencies
└── README.md          # This file
```

## Setup Instructions

### Prerequisites
- Node.js (v14 or higher)
- Java 17 or higher
- Maven
- MongoDB (local or cloud instance)

### Backend Setup
1. Navigate to the backend directory: `cd backend`
2. Install dependencies: `mvn clean install`
3. Configure MongoDB connection in `application.properties`
4. Run the application: `mvn spring-boot:run`
5. Backend will start on `http://localhost:8080`

### Frontend Setup
1. Navigate to the frontend directory: `cd frontend`
2. Install dependencies: `npm install`
3. Start the development server: `npm start`
4. Frontend will start on `http://localhost:3000`

### Quick Start (Windows)
- Run `start.ps1` for PowerShell
- Or run `start.bat` for Command Prompt
- Or manually start each service in separate terminals

### Database Setup
1. Install MongoDB locally or use MongoDB Atlas
2. Create a database named `marriagebureau`
3. The application will automatically create collections

## API Endpoints

- `GET /api/profiles` - Get all profiles
- `POST /api/profiles` - Create new profile
- `GET /api/profiles/{id}` - Get profile by ID
- `PUT /api/profiles/{id}` - Update profile
- `DELETE /api/profiles/{id}` - Delete profile
- `GET /api/profiles/search` - Search profiles with filters

## Features Description

### User Registration
- Complete profile creation with personal details
- Form validation and error handling
- Photo upload capability

### Search & Browse
- Filter by gender, age range, location, profession, religion
- Grid view of profile cards
- Detailed profile view

### Profile Management
- View detailed profile information
- Contact information display
- Interest expression functionality

## Usage

1. Start MongoDB service
2. Run the Spring Boot backend
3. Start the React frontend
4. Open `http://localhost:3000` in your browser
5. Register profiles and search for matches!

## Future Enhancements

- User authentication and authorization
- Photo upload to cloud storage
- Advanced matching algorithms
- Chat/messaging system
- Email notifications
- Admin panel for profile moderation
