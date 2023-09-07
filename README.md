# Flight Management System

This Flight Management System is a web application built using React for the frontend and Spring Boot for the backend. It utilizes MongoDB for data storage and follows RESTful API principles for communication between the client and server.

## Technologies Used

- **React**: The frontend is developed using React, a JavaScript library for building user interfaces.

- **Spring Boot**: The backend is built on Spring Boot, a Java-based framework for developing web applications.

- **MongoDB**: MongoDB is used as the database to store flight information.

- **Axios**: Axios is used for making HTTP requests between the frontend and backend.

## Features

- **Flight Registration**: Users can register new flights by providing flight name, destination, and price.

- **Flight Editing**: Existing flights can be edited with updated details.

- **Flight Deletion**: Flights can be deleted from the system.

- **Listing Flights**: The system lists all flights stored in the MongoDB database.

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
