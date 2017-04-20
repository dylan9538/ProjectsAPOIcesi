@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_senorCaraPapa
REM Autor: Silvia de la Torre D�az - 19-ene-2009
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------
cd ..
java -classpath ../lib/senorCaraPapa.jar;../test/lib/senorCaraPapaTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.senorCaraPapa.test.SeniorCaraDePapaTest
java -classpath ../lib/senorCaraPapa.jar;../test/lib/senorCaraPapaTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.senorCaraPapa.test.ParteTest