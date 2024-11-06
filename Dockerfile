FROM openjdk:17-jdk-slim

WORKDIR /app
ARG VERSION

# Copier le fichier JAR de l'application dans le conteneur
COPY target/tp-foyer-${VERSION}.jar /app/achat.jar
# Exposer le port sur lequel l'application écoute
EXPOSE 8084

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/achat.jar"]
