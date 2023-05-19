FROM openjdk:17-jdk-slim

COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
