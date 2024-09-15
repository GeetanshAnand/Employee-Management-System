# Use Maven to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy pom.xml and src/ directory into the container
COPY emproject/pom.xml /app/
COPY emproject/src /app/src

# Build the application
RUN mvn clean package

# Second stage: use OpenJDK image to run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (8081 in your case)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
