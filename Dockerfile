FROM openjdk:11
WORKDIR /app
COPY target/kotlin-rest-api-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]