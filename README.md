# Deals and Coupon Management Application

This is a simple web application for managing deals and coupons. It allows you to perform CRUD (Create, Read, Update, Delete) operations on coupons. The application is built using React for the frontend and Spring Boot for the backend.

## Features

- Register new coupons with details like merchant name, coupon code, expiry date, title, and description.
- Edit existing coupons.
- Delete coupons.
- Search for coupons by merchant name.
- View coupons in a paginated list.

## Usage

1. Clone the repository.

2. Navigate to the `flight-management-system` directory.

3. Run the Spring Boot backend:
   ```bash
   cd backend
   ./mvnw spring-boot:run
  Copy code
  cd frontend
  npm install
  npm start
  Access the application in your web browser at http://localhost:3000.
  
  ## API Endpoints

  
 - GET /api/v1/flight/getall: Get all flights.
 - POST /api/v1/flight/save: Register a new flight.
 - PUT /api/v1/flight/edit/{id}: Update an existing flight.
 - DELETE /api/v1/flight/delete/{id}: Delete a flight.
  
  Feel free to contribute to this project and improve the Flight Management System.
  
  Enjoy managing your flights!         
