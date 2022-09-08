package com.thererolando.groovybasics.lesson28asttrasnformation.tostring

import groovy.transform.ToString

/*
 @ToString permite generar el método toString de los atributos de la clase
 */
@ToString(includePackage = false, includeNames = true, excludes = ['notes'])
class Person {

    String first
    String last
    String email
    List<Integer> notes = [10,20,18,17]

}
