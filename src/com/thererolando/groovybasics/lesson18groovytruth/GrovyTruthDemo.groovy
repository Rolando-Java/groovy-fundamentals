package com.thererolando.groovybasics.lesson18groovytruth
/*
 Groovy Truth
 Se debe tomar en cuenta que en Groovy, las expresiones
 también pueden ser evaluadas como verdaderas o falsas.
 */
assert true
assert !false
assert ('a' =~ /\w/)
assert !('b' =~ /[^b]/)
assert ![]
assert [1]
assert ![:]
assert [1: 'lucas']
assert !''
assert 'a'
assert 8
assert -1234
assert 8.0
assert !0
assert !null

/*
 La Groovy Truth es posible, debido a que por detrás
 se hace uso del método sobrecargado asBoolean, el cual
 permite evaluar las distintas expresiones como verdaderas
 o falsas.
 Ahora bien, al crear nuestra propia clase, podemos sobreescribirlo
 de forma que adaptemos a la Groovy Truth a nuestras necesidades.
 */
class Person {
    String name
    Integer age

    boolean asBoolean() {
       this.age >= 20
    }
}

Person person = new Person(name: 'Luca', age: 21)

if (person) {
    println 'The person is correct'
} else {
    println 'The person is incorrect'
}


