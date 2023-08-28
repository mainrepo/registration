FROM eclipse-temurin:11-jdk-alpine
LABEL org.opencontainers.image.authors="shabdsnuti@outlook.com"
WORKDIR /app
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/app.jar"]