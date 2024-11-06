FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/tp-foyer-5.0.0.jar /app/achat.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8082

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/achat.jar"]
