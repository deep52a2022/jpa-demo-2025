
FROM amazoncorretto:17-alpine

LABEL maintainer="Deep Bawne deepbawne@gmail.com"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/app.jar"]


#
## Build stage
#FROM maven:3.9.5-eclipse-temurin-17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Runtime stage
#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "app.jar"]


## Use multi-stage to build the entire project
#FROM maven:3.9.5-eclipse-temurin-17 AS build
#WORKDIR /app
#
## Copy the full project, not just the module
#COPY . .
#
## Build the full project so the parent POM is available
#RUN mvn clean install -DskipTests
#
## Now build just the module
#WORKDIR /app/basic
#RUN mvn clean package -DskipTests
#
## Runtime image
#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY --from=build /app/basic/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

