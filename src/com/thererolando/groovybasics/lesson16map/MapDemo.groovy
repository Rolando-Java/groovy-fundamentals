package com.thererolando.groovybasics.lesson16map

// Mapas en Groovy

// la forma de inicializar un mapa vacio es con [:]
def map = [:]

// la instancia por defecto de un mapa es
println map.getClass().name // java.util.LinkedHashMap

// declarando un mapa con elementos
def person = [first:'Dan', last:'Vega', email:'danvega@gmail.com']
println "person = $person" // [first:Dan, last:Vega, email:danvega@gmail.com]

// obteniendo el valor una clave del mapa
println "person first = ${person.first}" // Dan

/*
 En un mapa puedes modificar el valor de una clave, y ademas
 agregar un nuevo clave valor, en caso la clave no exista en el mapa
 */
person.first = 'Luck'
person.twitter = '@therealdanvega'
println "person = $person" // [first:Luck, last:Vega, email:danvega@gmail.com, twitter:@therealdanvega]

/*
 Si quieres definir un nombre de clave que contenga espacios, puedes ponerlo entre comillas
 */
def twitter = [username:'@therealdanvega','email key':'danvega@gmail.com']
println "twitter = $twitter"

/*
 Si quieres que el nombre de clave venga de una variable, puedes usar interpolacion de strings
 o parentesis
 */
String emailKey = 'EmailAddress'
twitter = [username: '@therealdanvega',(emailKey):'danvega@gmail.com']
println "twitter = $twitter"

// Obtener el tamaño de un mapa
println person.size()

// Ordenar un mapa por la clave
println person.sort()

// Recorriendo un mapa
// recorriendo solo las claves del mapa
/*
 Al recorrer la lista con la forma for - in,
 no es necesario declarar el tipo
 */
for(key in person.keySet()) {
    println "key = $key"
}

// recorriendo los entry del mapa
for(entry in person) {
   println "${entry.key} : ${entry.value}"
}

// haciendo uso de closure para recorrer el mapa
person.each {
    println "${it.key} : ${it.value}"
}

person.each {key,value ->
   println "$key : $value"
}

// imprimir solo los valores del mapa
println person.values()
