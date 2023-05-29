FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8083
VOLUME /tmp
COPY target/*.jar Gateway_App-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar","/Gateway_App-0.0.1-SNAPSHOT.jar"]