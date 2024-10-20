# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot JAR file to the container
COPY target/backend-0.0.3-SNAPSHOT.jar /app/app.jar

# Expose the new port (8080 for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application on port 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--server.port=8080"]
