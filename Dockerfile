#FROM container-registry.oracle.com/graalvm/native-image:latest as graalvm
#RUN microdnf -y install wget unzip zip findutils tar
#
#COPY . /app
#WORKDIR /app
#
#RUN \
#    curl -s "https://get.sdkman.io" | bash; \
#    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
#    sdk install maven; \
#    mvn package -Pnative native:compile -DskipTests
#
#FROM container-registry.oracle.com/os/oraclelinux:9-slim
#
#EXPOSE 8005
#COPY --from=graalvm app/target/worthreadingservice /app
#
#ENTRYPOINT ["/app"]

##################FOR JVM COMPILE#######################

#FROM maven:3.8.1-openjdk-17 AS build
#WORKDIR /app
#COPY pom.xml ./
#COPY src ./src
#RUN mvn clean package
#
## Stage 2: Run the JAR
#FROM openjdk:17-jdk-slim
#COPY --from=build /app/target/*.jar /app.jar
#WORKDIR /app
#EXPOSE 8005
#ENTRYPOINT ["java","-jar","/app.jar"]


######################FOR RELEASE##########################
#
FROM openjdk:17-jdk-slim

#RUN mvn clean package
COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8005
ENTRYPOINT ["java","-jar","/app.jar"]
