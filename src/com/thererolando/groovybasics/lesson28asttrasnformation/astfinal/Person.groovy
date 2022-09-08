package com.thererolando.groovybasics.lesson28asttrasnformation.astfinal


import groovy.transform.Final
import groovy.transform.ToString

/*
 @Final permite agregar el modificador final
 a las clases, métodos, constructores y atributos.
 Usando final o @Final, se tiene el mismo resultado
 */

@ToString(includePackage = false, includeNames = true)
class Person {
    @Final
    String first = 'David'

    @Final
    def closure = {'soy un closure'}

    @Final
    def method() {
        'do something'
    }
}
