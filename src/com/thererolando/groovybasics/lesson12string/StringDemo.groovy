package com.thererolando.groovybasics.lesson12string

// Trabajando con Strings en Groovy

/*
 A diferencia de Java, en el que hay una distinción cuando se declara un carácter o una cadena.
 En groovy, por defecto cualquier cosa que se encuentre, ya sea entre comillas
 simples o compuestas, es un String.
 */
def c1 = 'c'
println c1.class.name // java.lang.String

def str1 = 'this is a string'
println str1.class.name // java.lang.String

def str2 = "this is a string"
println str2.class.name // java.lang.String

// String interpolation : el uso de comillas compuestas te permite hacer esto
def name = "Dan"
def msg = "Hello ${name}"
println msg.class.name // org.codehaus.groovy.runtime.GStringImpl
println "msg = $msg" // Hello Dan

def msg2 = "We can evaluate expressions here: ${4 + 4}"
println "msg2 = $msg2" // We can evaluate expressions here: 8

// Multiline Strings
def aLargeMsg1 = '''
This is a
multiline string
'''
println "aLargeMsg1 = $aLargeMsg1"

def aLargeMsg2 = """
This is a
multiline string
"""
println "aLargeMsg2 = $aLargeMsg2"

def aLargeMgs3 = """
Good morning!
My name is : ${name}
I am ${20 + 5} years old
"""
println "aLargeMgs3 = $aLargeMgs3"

// slashy
/*
 El slashy por defecto, realiza un escape sobre el slash.
 Además, también permite hacer uso de interpolación de strings
 */
def folder = /C:\groovy\dan\foo\var\${name}/
println "folder = $folder" //  C:\groovy\dan\foo\var\Dan

// dollar slashy

/*
 En este caso, como hay varios slashes en la cadena,
 nuestro slashy string dejo de trabajar, ya que no sabe donde inicia o termina
 la cadena. Es por eso, que se agregar un dollar al slashy, el cual indica el inicio y final
 de la expresión
 */
def url = $/http://www.google.com:${name}/$
println "url = $url" // http://www.google.com:Dan



