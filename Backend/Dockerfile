# Use official Gradle image to build
FROM gradle:8.5-jdk21 AS builder
ENV GRADLE_USER_HOME=/gradle-cache

WORKDIR /app
COPY . .

# Clean and build
RUN gradle clean build --no-daemon --stacktrace --info

# Use OpenJDK runtime for smaller image
FROM eclipse-temurin:21-jdk-jammy AS runtime
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","app.jar"]
