FROM openjdk:17

ENV DB_HOST=coffe
ENV DB_PORT=3307

COPY target/instacat-0.0.1-SNAPSHOT.jar.original /app/instacat.jar

CMD ["java", "-jar", "/app/instacat.jar"]