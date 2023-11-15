FROM openjdk:17-jdk-slim
LABEL maintainer='Mert Kaya'
ARG JAR_FILE=target/ticket-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 9007
ENTRYPOINT ["java", "-jar", "app.jar"]