package com.thererolando.groovybasics.lesson8asttransformation

import groovy.transform.Sortable
import groovy.transform.ToString

/*
 @Sortable
 -Implementa la interface Comparable, sobreescribiendo el método compareTo en la cual se incluye
 a las propiedades de la clase , en orden en que se declararon
 -Crea métodos estáticos Comparator para cada propiedad declarada en la clase
 */
@ToString
@Sortable
class Student {
    String first
    String last
}

def s1 = new Student(first: 'Joe', last: 'Bega')
def s2 = new Student(first: 'Dan', last: 'Vega')

def students = [s1, s2]
/*
 mandar false, para lograr que no modifique (mute) la propia lista
 */
println students.sort(false)

Comparator comparator = Student.comparatorByLast()
students.sort(comparator)
println students

