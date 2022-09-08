package com.thererolando.groovybasics.lesson28asttrasnformation.tupleconstructor

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/*
 @TupleConstructor ayuda a la creación de constructores personalizados por cada parámetro de
 la clase.
 El orden de los parámetros viene dado por cómo han sido declaradas en la clase.

 Si has declarado tu propio constructor en la clase, pero deseas usar la anotación
 @TupleConstructor, entonces debes establecer el atributo force en 'true'.
 */

@ToString(includePackage = false, includeFields = true)
@TupleConstructor(force = true)
@CompileStatic
class Person {
    String first
    String last
    String email
    boolean male

    Person(boolean male) {
        this.male = male
    }

}


