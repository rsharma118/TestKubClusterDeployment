#From tomcat:8.0.51-jre8-alpine
#RUN rm -rf /usr/local/tomcat/webapps/*
#COPY ./target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
#CMD ["catalina.sh","run"]

#FROM openjdk:8
#ADD target/restdeploy.jar restdeploy.jar
#EXPOSE 8080

FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/restdeploy.jar
WORKDIR /opt/app
COPY ${JAR_FILE} restdeploy.jar
ENTRYPOINT ["java","-jar","restdeploy.jar"]
