FROM openjdk:17-jdk-slim
MAINTAINER csen160.com
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]