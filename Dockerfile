FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM maven:3.8.7-eclipse-temurin-17
WORKDIR /app
COPY --from=build /app /app
ENTRYPOINT ["mvn"]