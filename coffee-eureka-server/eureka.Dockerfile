FROM openjdk:17

COPY target/eureka-server-1.0-SNAPSHOT.jar /app/eureka-server.jar

CMD ["java", "-jar", "/app/eureka-server.jar"]