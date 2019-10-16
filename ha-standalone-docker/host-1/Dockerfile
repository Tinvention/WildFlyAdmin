FROM jboss/wildfly

USER root
RUN yum install telnet telnet-server net-tools -y

USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ENTRYPOINT  /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c standalone-ha.xml -Djgroups.bind_addr=$(hostname -i) -Djboss.node.name=node-1 -Djboss.messaging.cluster.password=secretPwd -Djava.net.preferIPv4Stack=true
