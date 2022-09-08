package com.thererolando.groovybasics.lesson28asttrasnformation.builder

import groovy.transform.ToString
import groovy.transform.builder.Builder

import java.time.LocalDate

/*
 @Builder es usado para ayudar a construir instancias de clase, seteando solo las
 propiedades necesarias. Esta anotación soporta múltiples estrategias.

 -DefaultStrategy que crea una clase auxiliar anidada para la creación de instancias
 -SimpleStrategy para crear setters encadenados
 -ExternalStrategy donde anota una clase de constructor explícita mientras deja intacta alguna
  clase de construcción.
 -InitializerStrategy que crea una clase auxiliar anidada para la creación de instancias que
  cuando se usa con @CompileStatic, permite la creación de objetos con seguridad de tipos

  En nuestro caso estamos usando la estrategia por defecto.
 */
@Builder
@ToString(includePackage = false, includeNames = true)
class Developer {

    String first
    String last
    String middleInitial
    String email
    LocalDate hireDate
    List<String> languages

}
