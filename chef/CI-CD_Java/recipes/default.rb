#
# Cookbook Name:: CI-CD_Java
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

package 'git'
package 'mysql-server'
cookbook_file "/tmp/ems_dump.sql"
execute "mysql -uroot -proot < /tmp/ems_dump.sql" do
	ignore_failure true
end

#Setting of MYSQL Passwordssword
service "mysql" do 
	action :stop
end

cookbook_file "/tmp/pass.txt"

execute "mysqld_safe --init-file=/tmp/pass.txt &"



case node['platform']
when 'debian', 'ubuntu'
	package 'openjdk-7-jdk'  
	execute "export JAVA_HOME='/usr/lib/jvm/java-7-openjdk-amd64/'"
	package 'maven'
	package 'tomcat7'
	package 'tomcat7-admin'
when 'redhat', 'centos', 'fedora'
	package 'java-1.7.0-openjdk'
	execute 'export JAVA_HOME="/usr/lib/jvm/java-1.7.0-openjdk-1.7.0.85.x86_64/jre/bin"'
	#Process to install Tomcat 7
	#cookbook_file '/tmp/epel-release-6-8.noarch.rpm'
	#execute 'rpm -i /tmp/epel-release-6-8.noarch.rpm' do
	#	action :run
	#	ignore_failure true
	#end
	cookbook_file "/etc/yum.repos.d/epel.repo"
	cookbook_file "/etc/yum.repos.d/epel-apache-maven.repo"
	execute "yum repolist"
	package "tomcat"
	#package "apache-maven"
end


cookbook_file '/root/slave-agent.jnlp'

cookbook_file '/root/slave.jar'

cookbook_file '/root/jenkins-cli.jar'


#java -jar slave.jar -jnlpUrl http://172.27.59.64:8090/computer/Guaranga-Machine-Slave/slave-agent.jnlp
#execute "java -jar slave.jar -jnlpUrl http://172.27.59.64:8090/computer/Build-Server/slave-agent.jnlp"

#6872612926321ecac657c6fd0238cd0b98deb84918971025ea4aaafac9dbfe49
#5d4fe7fa546dfd46e25f5369de61192b1931e05ecb46fc4fbb43e5efdf8e0b03

#java -jar jenkins.war --argumentsRealm.passwd.user=password --argumentsRealm.roles.user=admin

#execute "java -jar slave.jar -jnlpUrl https://172.27.59.64:80909/computer/Gauranga-Machine-slave/slave-agent.jnlp -jnlpCredentilas manojshe:shahrukh@123"
#This is not able to get the slave.jar.

#execute 'making slave of jenkins' do 
#	user 'root'
#	command <<-BLAH
#	nohup java -jar slave.jar -jnlpUrl https://172.27.59.64:80909/computer/Gauranga-Machine-slave/slave-agent.jnlp -jnlpCredentilas manojshe:shahrukh@123 &
#	#disown
#	BLAH
#end

service "tomcat7" do
	action :restart
end

service "mysql" do
	action :start
end

#killer=`ps -aux | grep Chef-CI-CD | grep -v grep | awk '{print $2}'`

#execute "kill -9 #{killer}"

remote_file '/tmp/EmployeeApplicationSystem-1.0-SNAPSHOT.war' do
  source 'http://172.27.59.64:8081/artifactory/libs-snapshot-local/com/alm/web/EmployeeApplicationSystem/1.0-SNAPSHOT/EmployeeApplicationSystem-1.0-SNAPSHOT.war'
  mode '0755'
#  checksum '3a7dac00b1' # A SHA256 (or portion thereof) of the file.
end

