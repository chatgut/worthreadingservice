FROM eclipse-temurin:17-jdk
#RUN mvn clean package

COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
