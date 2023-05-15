FROM openjdk:17-jdk-slim
#RUN mvn package -Pnative native:compile -DskipTests

COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
