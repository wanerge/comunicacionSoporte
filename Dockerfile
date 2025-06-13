# Etapa 1: Construcción del proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecutar la app
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/comunicacionSoporte-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
