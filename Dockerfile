# Etapa 1: Construcción del proyecto
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con la app empaquetada
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
