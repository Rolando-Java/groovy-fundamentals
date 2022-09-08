package com.thererolando.groovybasics.lesson28asttrasnformation.canonical

import groovy.transform.Canonical
import groovy.transform.ToString

/*
 @Canonical es la combinación de las anotaciones @ToString, @EqualsAndHashCode y @TupleConstructor.
 Si tu no necesitas toda la funcionalidad de @Canonical, puede usar simplemente uno o más de las anotaciones
 individuales que componen a este, en caso necesites personalizarlo mejor.
 */
@Canonical
@ToString(includePackage = false, includeNames = true)
class Person {
    String first
    String last
    String email
}
