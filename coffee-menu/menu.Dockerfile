FROM openjdk:17

ENV DB_HOST=postgres
ENV DB_PORT=5432


COPY target/menu_microservice-1.0-SNAPSHOT.jar /app/menu_microservice.jar

CMD ["java", "-jar", "/app/menu_microservice.jar"]