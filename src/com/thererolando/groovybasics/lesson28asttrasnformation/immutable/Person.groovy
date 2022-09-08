package com.thererolando.groovybasics.lesson28asttrasnformation.immutable

import groovy.transform.Immutable
import groovy.transform.ToString

/*
 @Immutable es la combinación de las anotaciones @ToString, @EqualsAndHashCode, @ImmutableBase,
 @ImmutableOptions, @PropertyOptions, @TupleConstructor, @MapConstructor y @KnowImmutable

 Los atributos de la clase son automáticamente private y final, con captadores para obtener
 el valor de esos atributos.

 Si tu no necesitas toda la funcionalidad de @Immutable, puede usar simplemente uno o más de las
 anotaciones individuales que componen a este, en caso necesites personalizarlo mejor.
 */
@Immutable
@ToString(includePackage = false, includeNames = true)
class Person {
    String first
    String last
}
