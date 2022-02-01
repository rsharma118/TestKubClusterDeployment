FROM tomcat:latest
ADD target/*.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
