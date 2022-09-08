package com.thererolando.groovybasics.lesson28asttrasnformation.tupleconstructor

Person p1 = new Person(true)
println "p1 = $p1"
Person p2 = new Person('Dan', 'Vega')
println "p2 = $p2"
Person p3 = new Person('Dan','Vega','danvega@gmail.com',true)
println "p3 = $p3"
Person p4 = new Person(first: 'Dan', last: 'Vega', email: 'danvega@gmail.com', male: true)
println "p4 = $p4"

