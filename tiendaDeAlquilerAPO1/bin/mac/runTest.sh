#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_tiendaDeAlquiler
# Autor: Rafael Mu�oz Lattion - 05-mar-2012
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/tiendaDeAlquiler.jar:test/lib/junit.jar:test/lib/tiendaDeAlquilerTest.jar junit.swingui.TestRunner uniandes.cupi2.tiendaDeAlquiler.test.TiendaDeAlquilerTest
	
java -ea -classpath lib/tiendaDeAlquiler.jar:test/lib/junit.jar:test/lib/tiendaDeAlquilerTest.jar junit.swingui.TestRunner uniandes.cupi2.tiendaDeAlquiler.test.ProductoTest
cd bin/mac

stty echo
