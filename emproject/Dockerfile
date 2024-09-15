# Start with the official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Download the dependencies based on the pom.xml
RUN mvn dependency:go-offline

# Copy the rest of the application source code to the container
COPY src ./src

# Package the application (skipping tests to speed up the build)
RUN mvn clean package -DskipTests

# Use the official OpenJDK image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the application will run
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
