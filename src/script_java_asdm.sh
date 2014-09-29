#!/bin/bash

#ssconvert XLS_FILE OUTPUT_FILE

PATH_ASDMDATA="../ASDMData"
PATH_SOUCE_FILES="."
PATH_LIB=".."

ssconvert ${PATH_ASDMDATA}/Harvester-ASDM/asdms.xls ${PATH_ASDMDATA}/Harvester-ASDM/asdms.csv
awk -f harvester_asdm.awk ${PATH_ASDMDATA}/Harvester-ASDM/asdms.csv > ${PATH_ASDMDATA}/Harvester-ASDM/harvester_asdm_bruto.csv

# extrae elementos repetidos
#awk -f ARCHIVO_CODIGO_AWK RUTA_DATOS_ENTRADA > RUTA_DATOS_SALIDA
awk '!temp_array[$1]++' ${PATH_ASDMDATA}/Harvester-ASDM/harvester_asdm_bruto.csv > ${PATH_ASDMDATA}/Harvester-ASDM/harvester_asdm.csv

echo "conversion harvester ok"



rm ${PATH_SOUCE_FILES}/*.class
#javac -cp RUTA_LIBRERIAS/*  ruta_programa/Programa.java
# ../lib* asume que librerias estan en la carpeta padre
javac -cp ${PATH_SOUCE_FILES}:${PATH_LIB}/lib/* Launcher.java

echo "compilado"

#javac -cp RUTA_LIBRERIAS/*  RUTA_PROGRAMA/Programa RUTA_DATOS_ASDM_GENERAL RUTA_SALIDA_CSV
# ../lib* asume que librerias estan en la carpeta padre
java -cp ${PATH_SOUCE_FILES}:${PATH_LIB}/lib/* Launcher ${PATH_ASDMDATA}




#sudo apt-get install gnumeric