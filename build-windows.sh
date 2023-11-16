TOMCAT_HOME="C:\apache-tomcat-10.1.12\apache-tomcat-10.1.12"

# Detener Tomcat (forzar el cierre)
pkill -f catalina
sleep 5

# Compilar y empaquetar los módulos
mvn clean install

# Desplegar los archivos WAR en Tomcat
TOMCAT_WEBAPPS_DIR="$TOMCAT_HOME/webapps"

# Copiar archivos WAR a la carpeta webapps de Tomcat
cp application/target/application-1.0.jar $TOMCAT_WEBAPPS_DIR
cp domain/target/domain-1.0.jar $TOMCAT_WEBAPPS_DIR
cp infrastructure/target/infrastructure-1.0.war $TOMCAT_WEBAPPS_DIR

# Iniciar Tomcat
$TOMCAT_HOME/bin/startup.sh