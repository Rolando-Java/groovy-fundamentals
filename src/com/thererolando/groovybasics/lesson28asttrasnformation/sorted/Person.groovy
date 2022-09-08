package com.thererolando.groovybasics.lesson28asttrasnformation.sorted

import groovy.transform.Canonical
import groovy.transform.Sortable
import groovy.transform.ToString

/*
 @Sortable
 - Implementa la interface Comparable, sobreescribiendo el método compareTo en la cual
 se incluye a las propiedades de la clase, en orden en que se declararon.
 - Crea métodos estáticos Comparator para cada propiedad declarada en la clase.
 */
@Sortable
@Canonical
@ToString(includePackage = false, includeNames = true)
class Person {

    String first
    String last

}
