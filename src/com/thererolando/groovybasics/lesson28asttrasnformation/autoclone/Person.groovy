package com.thererolando.groovybasics.lesson28asttrasnformation.autoclone

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/*
 @AutoClone agrega la implementación de la clase Cloneable a la clase,
 además sobreescribe el método heredado clone(), lo cual permite crear otra instancia
 idéntica de esta clase.

 En el ejemplo anterior, se llama a super.clone(), que en este caso llama a clone() desde
 java.lang.Object. Esto hace una copia bit a bit de todas las propiedades (referencias y
 valores primitivos). Las propiedades como first tienen el tipo String, que no es clonable,
 por lo que se deja como copia bit a bit. Tanto Date como ArrayList se pueden clonar, por
 lo que se llamará al método clone() en cada una de esas propiedades. Para la lista, se
 realiza una copia superficial durante su método clone().
 */
@ToString(includePackage = false, includeNames = true)
@EqualsAndHashCode
@TupleConstructor
@AutoClone
class Person {
    final String first, last
    List favItems
    Date since
}
