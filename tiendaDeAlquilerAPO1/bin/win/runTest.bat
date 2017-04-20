@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n1_tiendaDeAlquiler
REM Autor: Rafael Mu�oz Lattion - 05-mar-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/tiendaDeAlquiler.jar;test/lib/junit.jar;test/lib/tiendaDeAlquilerTest.jar junit.swingui.TestRunner uniandes.cupi2.tiendaDeAlquiler.test.TiendaDeAlquilerTest
	
java -ea -classpath lib/tiendaDeAlquiler.jar;test/lib/junit.jar;test/lib/tiendaDeAlquilerTest.jar junit.swingui.TestRunner uniandes.cupi2.tiendaDeAlquiler.test.ProductoTest
cd bin/win