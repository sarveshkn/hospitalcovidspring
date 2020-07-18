FROM tomcat:8.5
VOLUME /tmp
COPY hospitalcovid-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#ENTRYPOINT [ "sh","-c","java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/ROOT.war" ]
CMD ["catalina.sh","run"]
