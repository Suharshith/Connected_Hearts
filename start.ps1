Write-Host "Starting Marriage Bureau Application..." -ForegroundColor Green

Write-Host "`nStarting MongoDB (make sure MongoDB is installed and running)" -ForegroundColor Yellow
Write-Host "If MongoDB is not running, please start it manually" -ForegroundColor Yellow

Write-Host "`nStarting Backend (Spring Boot)..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd C:\Users\suhar\Desktop\marriage-bureau\backend; mvn spring-boot:run"

Write-Host "`nWaiting for backend to start..." -ForegroundColor Yellow
Start-Sleep -Seconds 10

Write-Host "`nStarting Frontend (React)..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd C:\Users\suhar\Desktop\marriage-bureau\frontend; npm install; npm start"

Write-Host "`nApplications are starting..." -ForegroundColor Green
Write-Host "Backend: http://localhost:8080" -ForegroundColor White
Write-Host "Frontend: http://localhost:3000" -ForegroundColor White
Write-Host "`nPress any key to exit..." -ForegroundColor Gray
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
