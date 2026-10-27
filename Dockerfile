FROM maven:3-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn install

CMD ["java","-jar","target/appointment-booking-springboot-0.0.1-SNAPSHOT.jar"] 
