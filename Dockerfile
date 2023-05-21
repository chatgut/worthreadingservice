FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar /app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
