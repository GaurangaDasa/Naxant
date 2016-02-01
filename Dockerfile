FROM ubuntu:14.04
MAINTAINER Gauranga Rathod

#Installing environment - java7, maven3

RUN echo "deb-src http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN echo "deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN apt-get update && apt-get install openjdk-7-jdk maven3 -y --force-yes
RUN ln -s /usr/share/maven3/bin/mvn /usr/bin/mvn
#RUN apt-get update && apt-get install tomcat7 -y --fix-missing
#ADD run_script /bin/
#RUN chmod 755 /bin/run_script

#Copying source code

RUN mkdir /opt/naxant
COPY src/ /opt/naxant/src
COPY pom.xml /opt/naxant/pom.xml
WORKDIR /opt/naxant

#Running maven build script

RUN mvn clean package
