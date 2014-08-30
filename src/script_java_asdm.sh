#!/bin/bash

# agregar que extraiga los datos desde los xls


# extrae elementos repetidos
#awk -f ARCHIVO_CODIGO_AWK RUTA_DATOS_ENTRADA > RUTA_DATOS_SALIDA
awk '!temp_array[$1]++' ../ASDMData/PorProcesar/input_bruto.csv > ../ASDMData/PorProcesar/input.csv


#javac -cp RUTA_LIBRERIAS/*  ruta_programa/Programa.java
# ../lib* asume que librerias estan en la carpeta padre
javac -cp .:../lib/* Launcher.java

echo "compilado"

#javac -cp RUTA_LIBRERIAS/*  RUTA_PROGRAMA/Programa RUTA_DATOS_ASDM_GENERAL RUTA_SALIDA_CSV
# ../lib* asume que librerias estan en la carpeta padre
java -cp .:../lib/* Launcher ../ASDMData/ ../CSV/
