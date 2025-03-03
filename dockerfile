# Etapa 1: Construcción de la aplicación con Maven
FROM okteto/maven:3-openjdk AS builder
WORKDIR /app
# Copiamos el archivo pom.xml y descargamos las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline
# Copiamos el código fuente
COPY src ./src
# Compilamos y empaquetamos la aplicación omitiendo tests
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copiamos el jar generado desde la etapa de build
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]