FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*

ADD ./target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
COPY ./target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/demo.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
