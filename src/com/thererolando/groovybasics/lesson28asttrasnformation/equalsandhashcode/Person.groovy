package com.thererolando.groovybasics.lesson28asttrasnformation.equalsandhashcode

import groovy.transform.EqualsAndHashCode

/*
 @EqualsAndHashCode permite generar el método equals y hashCode de los
 atributos de la clase
 */
@EqualsAndHashCode(excludes = 'email')
class Person {
    String first
    String last
    String email
}
