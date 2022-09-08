package com.thererolando.groovybasics.lesson28asttrasnformation.mapconstructor

/*
 El uso de la anotación @MapConstructor, nos permite instanciar una clase
 pasando name-args, incluyendo a los atributos que son final.
 Cosa que no se podría realizar, si hicieras uso del constructor vacío o un
 constructor que reciba un mapa, pero declarado por ti y no por la anotación.
 */
Person p1 = new Person(name: 'David', last: 'Ken')
println "p1 = $p1"
Person p2 = new Person(name: 'David', last: 'Ken',male: false)
println "p2 = $p2"

