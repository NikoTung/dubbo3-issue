FROM openjdk:17
VOLUME /tmp
WORKDIR /opt/app
COPY target/consumer.jar /opt/app/consumer.jar
ENTRYPOINT java  ${JAVA_OPTS} -jar  /opt/app/consumer.jar
