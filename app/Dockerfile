FROM openjdk:8-jdk-alpine3.7
RUN apk update \
    && apk add ca-certificates wget \
    && update-ca-certificates
COPY contrast.jar contrast/contrast.jar
COPY newrelic.jar newrelic/newrelic.jar
COPY newrelic.yml newrelic/newrelic.yml
COPY nrcerts newrelic/nrcerts
COPY target/microservice-demo.jar app.jar
RUN chmod -R 777 contrast
EXPOSE 8080
ENV JAVA_OPTS="-javaagent:contrast/contrast.jar -Dcontrast.dir=contrast"
#ENV JAVA_OPTS="-javaagent:contrast/contrast.jar -javaagent:newrelic/newrelic.jar"
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

