FROM eclipse-temurin:21-java-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
EXPOSE 8080