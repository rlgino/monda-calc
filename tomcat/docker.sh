docker run \
  --name tomcat \
  -it \
  -p 8080:8080 \
  -v /Users/gluraschi/Proyects/workspace.pruebas/calculadora/tomcat/tomcat-users.xml:/usr/local/tomcat/conf/tomcat-users.xml \
  -v /Users/gluraschi/Proyects/workspace.pruebas/calculadora/tomcat/context.xml:/usr/local/tomcat/webapps.dist/manager/META-INF/context.xml \
  tomcat:9.0 \
  /bin/bash -c "mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2; mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps; catalina.sh run"