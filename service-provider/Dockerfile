FROM openjdk:17
VOLUME /tmp
WORKDIR /opt/app

COPY target/provider.jar /opt/app/provider.jar

ENTRYPOINT java ${JAVA_OPTS} -jar  /opt/app/provider.jar
