FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD ./target/portfolio-0.0.1-SNAPSHOT.jar app.jar
ADD ./application.properties application.properties
ENTRYPOINT ["java" ,"-jar","app.jar"]
EXPOSE 8080
