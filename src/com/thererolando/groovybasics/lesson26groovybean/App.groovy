package com.thererolando.groovybasics.lesson26groovybean

import com.thererolando.groovybasics.lesson26groovybean.domain.DoubleBean
import com.thererolando.groovybasics.lesson26groovybean.domain.Employee

Employee emp = new Employee(first: 'Dan', last: 'Vega', email: 'danvega@gmail.com')
println emp

Employee empDos = new Employee()
empDos.first = 'Dan'
empDos.last = 'Vega'
empDos.email = 'danvega@gmail.com'
println empDos

DoubleBean db = new DoubleBean()
db.value = 100

/*
 Groovy siempre va a priorizar el llamado de un getter o setter
 del atributo, en caso se encuentre declarado en la clase.
 En este caso groovy invoca al método getValue de la variable, mas no
 directamente a la variable public value
 */
println db.value // 100

/*
 Para llamar directamente a un atributo de clase en Groovy, y hacer caso omiso
 a los métodos getter o setter que puedan estar declarados en este, se hace uso
 de '@'
 */
println db.@value




