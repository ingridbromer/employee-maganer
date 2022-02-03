FROM openjdk:8-jdk-alpine

# Install Bash
RUN apk add --no-cache bash libc6-compat

#VOLUME /tmp

# Copy resources
WORKDIR /
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
#COPY callback/ /callback/
#RUN ls -la /callback/*
COPY target/*.jar app.jar

# Wait for Zookeeper and Kafka and mysql to be available and run application
CMD ./wait-for-it.sh -s -t 30 $MYSQL_HOST:$MYSQL_PORT -- java -Xmx4G -jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
