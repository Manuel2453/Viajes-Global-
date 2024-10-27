# Usar la imagen base de OpenJDK para ejecutar aplicaciones Java
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo .jar generado en el contenedor
COPY target/MicroservicePagos-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que correrá el microservicio
EXPOSE 8083

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
