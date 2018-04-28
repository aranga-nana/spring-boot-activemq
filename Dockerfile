FROM openjdk:8u151-jre-alpine3.7
RUN apk add --update \
        bash \
        curl \
        && rm -rf /var/cache/apk/*
RUN mkdir /opt/app -p
WORKDIR /opt/app
COPY build/libs/*.jar app.jar
ENV SERVER_PORT 80
EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

