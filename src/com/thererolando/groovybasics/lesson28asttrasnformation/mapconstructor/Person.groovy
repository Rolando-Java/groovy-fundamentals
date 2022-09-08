package com.thererolando.groovybasics.lesson28asttrasnformation.mapconstructor

import groovy.transform.Final
import groovy.transform.MapConstructor
import groovy.transform.ToString

/*
  @MapConstructor crear un constructor que recibe un mapa como parámetro.
  Este constructor puede ser personalizado mediante los atributos que ofrece
  la anotación.
 */
@ToString(includePackage = false, includeNames = true)
@MapConstructor
class Person {
    String name
    String last
    @Final
    boolean male = true

}
