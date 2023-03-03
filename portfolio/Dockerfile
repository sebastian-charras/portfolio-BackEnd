FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD ./dist/portfolio-1.0.jar app.jar
ADD ./dist/application.properties application.properties
ENTRYPOINT ["java" ,"-jar","app.jar"]
EXPOSE 8080
