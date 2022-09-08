package com.thererolando.groovybasics.lesson28asttrasnformation.builder

import java.time.LocalDate
import java.time.ZoneId

Developer dev = Developer
        .builder()
        .first('Dan')
        .last('Vega')
        .middleInitial('A')
        .email('danvega@gmail.com')
        .hireDate(LocalDate.now(ZoneId.systemDefault()))
        .languages(['Javal', 'Groovy'])
        .build()
println "dev = $dev"

/*
 OJO:
 Groovy coloca en su documentación que puede que no le encuentras valor al uso de la
 anotación AST @Builder, ya que en groovy puedes hacer uso de 'names-args constructor'
 o del closure 'with'
 */

// name-args constructor
/*
 Recuerda que para esta forma es necesario que la clase
 tenga un constructor por defecto, o bien definido un constructor que recibe
 como parámetro un mapa.
 */
Developer dev2 = new Developer(first: 'Dan', last: 'Vega', middleInitial: 'A',
        email: 'danvega@gmail.com', hireDate: LocalDate.now(ZoneId.systemDefault()),
        languages: ['Java', 'Groovy'])
println "dev2 = $dev2"

// closure with
/*
 Pasar el parámetro true al atributo returning del closure with, para que te retorne
 la instancia Developer construida.
 */
Developer dev3 = new Developer().with(true) {
    first = 'Dan'
    last = 'Vega'
    middleInitial = 'A'
    email = 'danvega@gmail.com'
    hireDate = LocalDate.now(ZoneId.systemDefault())
    languages = ['Java','Groovy']
}
println "dev3 = $dev3"




