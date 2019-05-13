FROM java:8
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ADD /target/lanchonete-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/lanchonete-0.0.1-SNAPSHOT.jar"]