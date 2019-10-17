FROM jboss/wildfly

USER root
RUN yum install telnet telnet-server net-tools -y

USER jboss
ADD ./host-slave-with-username.xml /opt/jboss/wildfly/domain/configuration/host-slave-with-username.xml

CMD /opt/jboss/wildfly/bin/domain.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --host-config=host-slave-with-username.xml -Djboss.domain.master.address=master -Djgroups.bind_addr=$(hostname -i) -Djboss.node.name=node-1 -Djboss.messaging.cluster.password=secretPwd -Djava.net.preferIPv4Stack=true