package com.thererolando.groovybasics.lesson8asttransformation

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/*
 @ToString permite generar el método toString de los atributos de clase
 @EqualsAndHashCode permite generar el método equals y hashCode de los atributos de clase
 @TupleConstructor ayuda a la creación de constructores personalizados por cada parámetro de la clase.
 El orden de los parámetros viene dado por las propiedades de cualquier superclase
 */
@ToString
@EqualsAndHashCode
@TupleConstructor
class Person {
    String name
    int edad
    Address address
}

/*
 @Canonical es la combinación de las anotaciones @ToString, @ToString y @TupleConstructor
 */
@Canonical
class Address {
   String name
    int number
}

Person personUno = new Person([name:'ana',edad:12,address:[name:'miraflores',number:244]])
Person personDos = ['ana',12,(['miraflores',244] as Address)]
assert personUno == personDos
println personUno
println personDos