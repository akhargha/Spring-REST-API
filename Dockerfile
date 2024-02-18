# This is a multi-stage build. In the first stage, we build the application.
FROM gradle:jdk17 as build

# Copy the source code
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Build the application
RUN gradle build --no-daemon

# Use OpenJDK for running the application
FROM openjdk:17-jdk

# Copy the jar from the build stage to the /app directory of the new stage
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

# Run the application
ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
