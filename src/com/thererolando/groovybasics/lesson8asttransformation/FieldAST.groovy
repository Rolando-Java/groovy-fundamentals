package com.thererolando.groovybasics.lesson8asttransformation

import groovy.transform.Field

/*
 @Field, permite convertir una variable local en atributo de clase
 */
@Field String name = 'luca'
println "La variable name con valor $name ahora es atributo de clase"

