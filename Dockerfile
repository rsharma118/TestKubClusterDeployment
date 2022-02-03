From tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/restdeploy.war /usr/local/tomcat/webapps/restdeploy.war
CMD ["catalina.sh","run"]

#FROM openjdk:8
#ADD target/restdeploy.jar restdeploy.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","restdeploy.jar"]
