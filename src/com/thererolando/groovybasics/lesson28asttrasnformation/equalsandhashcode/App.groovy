package com.thererolando.groovybasics.lesson28asttrasnformation.equalsandhashcode

Person p1 = new Person(first: 'Dan', last: 'Vega', email: 'danvega@gmail.com')
Person p2 = new Person(first: 'Dan', last: 'Vega', email: 'dan.vega@gmail.com')

assert p1 == p2

