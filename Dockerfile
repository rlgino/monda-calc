FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/calculadora-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
