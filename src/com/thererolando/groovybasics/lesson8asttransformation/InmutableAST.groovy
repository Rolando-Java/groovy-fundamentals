package com.thererolando.groovybasics.lesson8asttransformation

import groovy.transform.Immutable

import java.time.LocalDate

/*
 @Immutable es la combinación de las anotaciones @ToString, @EqualsAndHashCode, @ImmutableBase,
 @ImmutableOptions, @PropertyOptions, @TupleConstructor, @MapConstructor y @KnownImmutable
 La clase se convierte automáticamente en final
 Los atributos de clase son automáticamente private y final, con captadores para obtener
 el valor de esos atributos
 */

@Immutable
class Customer {
    String first
    String last
    int age
    LocalDate since
    List favItems
}

Customer customerOne = new Customer([first   : 'mateo', last: 'pendial', age: 30,
                                     since   : LocalDate.of(1998, 6, 13),
                                     favItems: ['book1', 'book2']])
Customer customerTwo = ['mateo', 'pendial', 30, LocalDate.of(1998, 6, 13),
                        ['book1', 'book2']]
assert customerOne == customerTwo
println customerOne
println customerTwo
