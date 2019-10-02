FROM jboss/wildfly

USER root
RUN yum install telnet telnet-server net-tools -y

USER jboss
ADD ./host-slave-with-username.xml /opt/jboss/wildfly/domain/configuration/host-slave-with-username.xml