FROM openjdk:17

ENV POSTGRES_HOST=postgres
ENV POSTGRES_PORT=5432
ENV REDIS_HOST=redis
ENV REDIS_PORT=6379


COPY target/bucket-1.0-SNAPSHOT.jar /app/bucket.jar

CMD ["java", "-jar", "/app/bucket.jar"]