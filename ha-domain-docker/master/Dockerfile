FROM jboss/wildfly

USER root
RUN yum install telnet telnet-server net-tools -y

USER jboss

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
RUN /opt/jboss/wildfly/bin/add-user.sh slave slave --silent

ADD ./domain-master.xml /opt/jboss/wildfly/domain/configuration/domain-master.xml
ADD ./host-master.xml /opt/jboss/wildfly/domain/configuration/host-master.xml

       