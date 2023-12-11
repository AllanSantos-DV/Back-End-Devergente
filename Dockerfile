FROM openjdk:17-jdk-alpine
COPY target/DeVerGente-0.0.1-SNAPSHOT.jar devergente.jar
ENTRYPOINT ["java","-jar","/devergente.jar"]