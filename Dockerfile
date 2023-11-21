FROM openjdk:19

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} productservice.jar

ENTRYPOINT ["java","-jar", "/productservice.jar"]

EXPOSE 9090