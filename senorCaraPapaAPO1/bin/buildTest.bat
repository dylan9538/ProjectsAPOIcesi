@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_senorCaraPapa
REM Autor: Silvia de la Torre Díaz - 19-ene-2009
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Asegura la creación de los directorios classes y lib en test
REM ---------------------------------------------------------

cd ../test
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio test/source
REM ---------------------------------------------------------

cd source

javac -classpath ../../lib/senorCaraPapa.jar;../lib/junit.jar -d ../classes/ uniandes/cupi2/senorCaraPapa/test/*.java


REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM ---------------------------------------------------------

cd ../classes

jar cf ../lib/senorCaraPapaTest.jar uniandes/* -C ../data .

cd ../../bin

pause