FROM openjdk:17-jdk
ADD target/ACME.jar ACME.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ACME.jar"]