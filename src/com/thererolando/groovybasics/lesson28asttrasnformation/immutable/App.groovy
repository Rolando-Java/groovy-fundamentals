package com.thererolando.groovybasics.lesson28asttrasnformation.immutable

Person p1 = new Person(first: 'Dan', last: 'Vega')
Person p2 = new Person(first: 'Dan', last: 'Vega')
println "p1 = $p1"
println "p2 = $p2"

assert p1 == p2

// Error, porque la clase se comporta solo lectura
//p1.first = 'Luck'


