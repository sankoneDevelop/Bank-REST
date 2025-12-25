FROM eclipse-temurin:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} card-management.jar
ENTRYPOINT ["java","-jar","/card-management.jar"]
