package com.thererolando.groovybasics.test.practice

import groovy.transform.Final
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
enum WeekDay {

    MONDAY('lunes', 1), TUESDAY('martes', 2), WEDNESDAY('miercoles', 3), THURSDAY('jueves', 4),
    FRIDAY('viernes', 5), SATURDAY('sabado', 6), SUNDAY('domingo', 7)

    @Final
    String nameMonth
    @Final
    Integer numMonth

}