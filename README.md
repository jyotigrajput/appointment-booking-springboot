# Appointment Booking - Simple Spring Boot App

This is a minimal Spring Boot web application demonstrating an appointment booking system.
- Java 17, Spring Boot 3.x
- H2 in-memory database
- Thymeleaf UI

## Run locally:

### Option 1: Run with Maven directly
1. Build and run with Maven:
   ```
 mvn spring-boot:run
   ```

2. Open browser:
   http://localhost:8080/appointments

### Option 2: Build and run JAR
1. Build the package:
   ```
      mvn clean package
   ```

2. Run the JAR file:
   ```
   java -jar target/appointment-booking-springboot-0.0.1-SNAPSHOT.jar
   ```

3. Open browser:
   http://localhost:8080/appointments

## H2 Console:
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:bookingdb

This project was generated automatically.
