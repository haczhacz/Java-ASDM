#!/bin/bash

#ssconvert XLS_FILE OUTPUT_FILE

# ruta que contiene todo
BASE_PATH="$( cd .. "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ASDMDATA_PATH=$BASE_PATH"/ASDMData"
PATH_SOURCE_FILES=$BASE_PATH"/src"
PATH_LIB=$BASE_PATH"/lib"
PATH_HARVESTER=$ASDMDATA_PATH"/Harvester-ASDM"

ssconvert --export-type Gnumeric_stf:stf_assistant -O 'separator="~"' $PATH_HARVESTER"/asdms.xls" $PATH_HARVESTER"/asdms.csv"


awk -f ${PATH_SOURCE_FILES}/harvester_asdm.awk ${PATH_HARVESTER}/asdms.csv > ${PATH_HARVESTER}/harvester_asdm_bruto.csv

# extrae elementos repetidos
#awk -f ARCHIVO_CODIGO_AWK RUTA_DATOS_ENTRADA > RUTA_DATOS_SALIDA
awk '!temp_array[$1]++' ${PATH_HARVESTER}/harvester_asdm_bruto.csv > ${PATH_HARVESTER}/harvester_asdm.csv

echo "conversion harvester ok"


rm ${PATH_SOURCE_FILES}/*.class
#javac -cp RUTA_LIBRERIAS/*  ruta_programa/Programa.java
# ../lib* asume que librerias estan en la carpeta padre
javac -cp ${PATH_SOURCE_FILES}:${PATH_LIB}/* Launcher.java

echo "compilado"

#javac -cp RUTA_LIBRERIAS/*  RUTA_PROGRAMA/Programa RUTA_DATOS_ASDM_GENERAL RUTA_SALIDA_CSV
# ../lib* asume que librerias estan en la carpeta padre
java -cp ${PATH_SOURCE_FILES}:${PATH_LIB}/* Launcher ${ASDMDATA_PATH}


# Creacion carpeta procesados, solo si ya no existe
if [ ! ${ASDMDATA_PATH}/Procesados ]; then
	mkdir ${ASDMDATA_PATH}/Procesados
fi


# mover carpetas
# Para eso, busca el nombre de los archivos que han sido trabajados en log.txt
OLDIFS=$IFS
IFS=$'\t\n'
declare -i count=0
for A in $(cat ${ASDMDATA_PATH}/Procesados/log.txt ) ; do
  count=$((count+1))
  if [ $count = 3 ]; then
	echo ${ASDMDATA_PATH}/PorProcesar/$A 
	echo ${ASDMDATA_PATH}/Procesados/$A
	mv ${ASDMDATA_PATH}/PorProcesar/$A ${ASDMDATA_PATH}/Procesados/$A
	count=$((0))
  fi
done
IFS=$OLDIFS






#mv ${ASDMDATA_PATH}/PorProcesar/prueba ${ASDMDATA_PATH}/Procesados/

#sudo apt-get install gnumeric
