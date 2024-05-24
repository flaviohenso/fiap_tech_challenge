FROM amazoncorretto:21
ENV ENVIRONMENT=dev
ADD target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]