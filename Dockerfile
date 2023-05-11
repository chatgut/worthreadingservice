FROM openjdk:17-jdk-slim
#RUN mvn clean package
#./mvnw test -PnativeTest

COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
