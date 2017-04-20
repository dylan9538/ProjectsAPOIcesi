#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_tiendaDeAlquiler
# Autor: Rafael Muñoz Lattion - 05-mar-2012
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución del programa
# ---------------------------------------------------------

cd ../..
java -ea -classpath ./lib/tiendaDeAlquiler.jar uniandes.cupi2.tiendaDeAlquiler.interfaz.InterfazTiendaDeAlquiler
cd bin/mac

stty echo
