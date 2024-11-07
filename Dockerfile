# Utiliser une image de base Java spécifique depuis Docker Hub
FROM openjdk:17-jdk-slim

ARG VERSION

WORKDIR /app

COPY target/tp-foyer-${VERSION}.jar /app/tp-foyer.jar

# Exposer le port sur lequel l'application écoute

EXPOSE 8082


# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/tp-foyer.jar"]
