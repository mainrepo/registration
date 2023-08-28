FROM eclipse-temurin:11-jdk-alpine
MAINTAINER gaurav.joshi@email.com
WORKDIR /app
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/app.jar"]