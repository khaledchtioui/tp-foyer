# Utiliser une image de base Java spécifique depuis Docker Hub
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur, la version est dynamique
COPY target/tp-foyer-${VERSION}.jar /app/tp-foyer.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8082

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/tp-foyer.jar"]
