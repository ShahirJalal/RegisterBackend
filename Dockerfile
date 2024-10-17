# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot JAR file from the target directory to the container
COPY target/backend-0.0.3-SNAPSHOT.jar /app/app.jar

# Expose the port your application runs on (usually 8080 for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
