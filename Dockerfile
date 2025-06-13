#Usar la imagen base de OpenJDK
FROM eclipse-temurin:17-jre

# Setea el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR generado del build stage
COPY target/comunicacionSoporte-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la app (Render te asigna uno dinámico, se configura en app)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java","-jar","/app.jar"]
