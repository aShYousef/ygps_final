FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENV PORT 9003
EXPOSE 9003
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} UserMicroApplication.jar
ENTRYPOINT ["java","-jar","/UserMicroApplication.jar"]




















#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#ENV PORT 9003
#EXPOSE 9003
#COPY build/libs/UserMicroApplication-0.0.1-SNAPSHOT.jar UserMicroApplication.jar
#ENTRYPOINT ["java","-jar","/UserMicroApplication.jar"]

## --- Build Stage ---
## Use a JDK image to build the application
#FROM eclipse-temurin:17-jdk-alpine AS builder
#
## Set the working directory
#WORKDIR /app
#
## Copy build files and download dependencies
#COPY gradlew .
#COPY gradle ./gradle
#COPY build.gradle .
#COPY settings.gradle .
#RUN ./gradlew dependencies
#
## Copy the rest of the source code and build the application
#COPY src ./src
#RUN ./gradlew bootJar
#
## --- Final Stage ---
## Use a lightweight JRE image to run the application
#FROM eclipse-temurin:17-jre-alpine
#
## Set an argument for the JAR file location from the build stage
#ARG JAR_FILE=/app/build/libs/*.jar
#
## Set environment variable for the port
#ENV PORT 9003
#EXPOSE 9003
#
## Create a volume for temp files
#VOLUME /tmp
#
## Copy the JAR file from the 'builder' stage to the final image
#COPY --from=builder ${JAR_FILE} app.jar
#
## Set the entrypoint to run the application
#ENTRYPOINT ["java", "-jar", "/app.jar"]



#FROM ubuntu:latest
#LABEL authors="Dev A Yousef"
#
#ENTRYPOINT ["top", "-b"]