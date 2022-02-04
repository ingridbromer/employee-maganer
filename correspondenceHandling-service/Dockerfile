FROM openjdk:11-jdk-alpine

# Install Bash
RUN apk add --no-cache bash libc6-compat

#VOLUME /tmp

# Copy resources
WORKDIR /
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
COPY target/*.jar app.jar

