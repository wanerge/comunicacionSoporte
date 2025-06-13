#Usar la imagen base de OpenJDK
FROM openjdk:17-jre-slim

# Setea el directorio de trabajo en el contenedor
WORKDIR /app

# Copia archivos pom.xml y fuentes para instalar dependencias
COPY pom.xml .
COPY src ./src

# Construye el proyecto, sin tests para acelerar
RUN .\mvnw clean package -DskipTests

# Usa una imagen más ligera para ejecutar el JAR
FROM eclipse-temurin:17-jre-alpine

# Copia el JAR generado del build stage
COPY --from=build /app/target/comunicacionSoporte-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la app (Render te asigna uno dinámico, se configura en app)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java","-jar","/app.jar"]
