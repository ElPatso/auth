FROM adoptopenjdk/openjdk11:latest
RUN mkdir /app
COPY auth-0.0.1-SNAPSHOT.jar /app
EXPOSE 9100
ENTRYPOINT ["java", "-jar", "/app/auth-0.0.1-SNAPSHOT.jar"]
