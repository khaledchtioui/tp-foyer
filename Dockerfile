FROM openjdk:17-jdk-slim

ARG VERSION

WORKDIR /app

COPY target/tp-foyer-${VERSION}.jar /app/tp-foyer.jar


EXPOSE 8082


ENTRYPOINT ["java", "-jar", "/app/tp-foyer.jar"]
