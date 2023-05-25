FROM openjdk:17-jdk-slim
COPY build/libs/game-service-0.0.1-SNAPSHOT.jar game-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/game-service.jar"]
