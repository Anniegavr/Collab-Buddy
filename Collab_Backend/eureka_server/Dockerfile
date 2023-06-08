# Use an OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8081

# Copy the JAR file from the target directory on the host to the container
COPY target/*.jar app.jar

# Define the command to run your Spring Boot app
CMD ["java", "-jar", "app.jar"]