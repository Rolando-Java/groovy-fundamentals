package com.thererolando.groovybasics.test.testdos

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

class Developer {

    String first
    String last
    String email
    List<String> languages

    Developer() {
        this.languages = []
    }

    @Override
    Object invokeMethod(String name, Object args) {
        println "invokedMethod() called with args $args"
    }

    @Override
    Object getProperty(String propertyName) {
        println "getProperty called..."
        this.metaClass.getProperty(this, propertyName)
    }

    @Override
    void setProperty(String propertyName, Object newValue) {
        println "setProperty() called with name $propertyName and newValue $newValue"
        this.metaClass.setProperty(this, propertyName, newValue)
    }
}

Developer developer = new Developer(first: 'Dan', last: 'Vega', email: 'danvega@gmail.com')
developer.writeCode('Groovy')
println developer.first
developer.languages = ['Groovy', 'Java']

Expando expando = new Expando()
expando.first = 'Dan'
expando.last = 'Vega'
expando.email = 'danvega@gmail.com'
expando.getFullName = { ->
    "$first $last"
}
println expando.toString()
println expando.getFullName()

@ToString(includeNames = true, includePackage = false)
class Person {
    String first
    String last
}

def person = new Person(first: 'Dan', last: 'Vega')
person.metaClass.email = 'danvega@gmail.com'
println "person = $person"
println person.email


// Aplicando la teoría con la clase String
/*
 Se observa que el delegate toma el valor de la instancia String, cuando
 el closure upper es invocado
 */
String.metaClass.upper = {
    delegate.toUpperCase()
}
println 'name'.upper() // Name

// Aplicando la teoría con la clase Integer
/*
 Se observa que el delegate toma el valor de la instancia Integer, cuando
 el closure timesTwo es invocado
 */
Integer.metaClass.timesTwo = {
    delegate * 2
}

println 2.timesTwo() // 4

@EqualsAndHashCode
@ToString(includePackage = false, includeNames = true)
class Student {
    String name
    int age
}

Student student = new Student(name: 'Joe', age: 27)
Student student2 = new Student(name: 'Joe', age: 27)

/*
 En groovy para que verdaderamente usemos el operador ==
 y comparemos las direcciones en memoria, se debe usar
 el método is()
 */
assert student == student2
assert !student.is(student2)

class A {
    int age = 1
}

class B extends A {
    int age = 2

    void imprimir() {
        println "age = ${age}"
    }
}

class C extends B {
    int age = 3

    void imprimir2() {
        this.imprimir()
    }
}

new C().imprimir2()






















