#!/bin/bash

TOMCAT_HOME="/home/balamkiche/apache-tomcat-10.1.12"

# Detener Tomcat (forzar el cierre)
pkill -f catalina
sleep 5