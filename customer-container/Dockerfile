#BUILDER
FROM openjdk:8u342-jdk as builder
WORKDIR /tmp/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

#APP IMAGE
FROM openjdk:8u342-jdk
WORKDIR /opt/app
ARG BUILD_DIR=/tmp/app
COPY --from=builder ${BUILD_DIR}/dependencies/ ./
COPY --from=builder ${BUILD_DIR}/snapshot-dependencies/ ./
COPY --from=builder ${BUILD_DIR}/spring-boot-loader/ ./
COPY --from=builder ${BUILD_DIR}/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]