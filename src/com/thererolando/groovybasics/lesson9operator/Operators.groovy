package com.thererolando.groovybasics.lesson9operator

import com.thererolando.groovybasics.lesson8asttransformation.Student

// Arithmetic operators
assert 10 + 1 == 11
assert 10 - 1 == 9
assert 10 * 2 == 20
assert 10 / 5 == 2
assert 10 % 3 == 1
assert 10 ** 2 == 100

// The binary arithmetic operators we have seen above are also available in an assignment form:
// += -= *= /= %= **=
def a = 10
a += 5 // a = a + 5
assert a == 15

// Relation operators
/*
 En groovy el operador == por detrás llama al método equals
 */
assert 1 + 2 == 3
assert 3 != 4
assert -2 < 3
assert 2 <= 2
assert 3 <= 4
assert 5 > 1
assert 5 >= -2

// Logical operators
assert !false
assert true && true
assert false || true
assert false ^ true

// Conditional Operators
    // Ternary Operator
    String result = ''
    String s = ''

    result = s ? 'Found' : 'Not Found'
    println result

    // Elvis operator
    result = s ?: 'Not Found'
    println result

// Object Operators
    // Safe navigation Operator

    Student student = new Student(first: 'Marlo')
    student = null
    // Java
    if(student != null && student.first != null && student.first.equals('Marlo')) {
       println 'Hola soy Marlo'
    }

    // Groovy
    if(student?.first == 'Marlo') {
       println 'Hola soy Marlo'
    }
