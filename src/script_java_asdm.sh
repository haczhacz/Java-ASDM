#!/bin/bash

#ssconvert XLS_FILE OUTPUT_FILE
ssconvert ../ASDMData/Harvester-ASDM/asdms.xls ../ASDMData/Harvester-ASDM/asdms.csv
awk -f harvester_asdm.awk ../ASDMData/Harvester-ASDM/asdms.csv > ../ASDMData/Harvester-ASDM/harvester_asdm_bruto.csv

# extrae elementos repetidos
#awk -f ARCHIVO_CODIGO_AWK RUTA_DATOS_ENTRADA > RUTA_DATOS_SALIDA
awk '!temp_array[$1]++' ../ASDMData/Harvester-ASDM/harvester_asdm_bruto.csv > ../ASDMData/Harvester-ASDM/harvester_asdm.csv

echo "conversion harvester ok"




#javac -cp RUTA_LIBRERIAS/*  ruta_programa/Programa.java
# ../lib* asume que librerias estan en la carpeta padre
javac -cp .:../lib/* Launcher.java

echo "compilado"

#javac -cp RUTA_LIBRERIAS/*  RUTA_PROGRAMA/Programa RUTA_DATOS_ASDM_GENERAL RUTA_SALIDA_CSV
# ../lib* asume que librerias estan en la carpeta padre
java -cp .:../lib/* Launcher ../ASDMData/ ../CSV/




#sudo apt-get install gnumeric