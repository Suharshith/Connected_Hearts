@echo off
echo Starting Marriage Bureau Application...

echo.
echo Starting MongoDB (make sure MongoDB is installed and running)
echo If MongoDB is not running, please start it manually

echo.
echo Starting Backend (Spring Boot)...
start cmd /k "cd backend & mvn spring-boot:run"

echo.
echo Waiting for backend to start...
timeout /t 10

echo.
echo Starting Frontend (React)...
start cmd /k "cd frontend & npm install & npm start"

echo.
echo Applications are starting...
echo Backend: http://localhost:8080
echo Frontend: http://localhost:3000
echo.
echo Press any key to exit...
pause
