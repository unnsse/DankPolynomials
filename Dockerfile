# Use Amazon Corretto JDK 8 to match your Gradle configuration
FROM amazoncorretto:8-alpine

# Install bash (needed for gradlew script)
RUN apk add --no-cache bash

# Set up work directory to match your app structure
WORKDIR /app

# Copy Gradle wrapper files from root
COPY gradlew ./
COPY gradle/wrapper/gradle-wrapper.jar gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/

# Make gradlew executable
RUN chmod +x gradlew

# Copy root-level Gradle files if they exist
COPY settings.gradle.kts gradle.properties* ./

# Copy the app folder contents directly to /app
COPY app/build.gradle.kts ./
COPY app/src ./src

# Set JAVA_HOME to use the correct Java version
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV PATH=$PATH:$JAVA_HOME/bin

# Download dependencies (this will also download Gradle if needed)
RUN ./gradlew --no-daemon dependencies || return 0

# Build the application
RUN ./gradlew --no-daemon build

# Run the application
CMD ["./gradlew", "run"]