package com.thererolando.groovybasics.lesson28asttrasnformation.typecheckedcompilestatic

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

class Foo {
    def bar = "bar"
}

class TestTC {
    Foo foo

    TestTC() {
        foo = new Foo()
        foo.metaClass.getBar = { 'metaClass bar' }
    }

    /*
     @TypeChecked solo verifica los tipos durante la compilación, pero el código
     compilado se comporta igual que sin @TypeChecked. Es decir, que aún permite
     el uso del MOP, pero no por ejemplo el uso de propertyMissing.
     */
    @TypeChecked
    def typed() {
        foo.bar
    }

    /*
     @CompileStatic verifica de manera similar a @TypeChecked, pero también modifica
     el código que sea seguro para tipos en tiempo de ejecución, lo que significa que métodos
     que usan la programación dinámica como el uso del MOP, fallarán.
     */
    @CompileStatic
    def compiled() {
        foo.bar
    }
}

assert new TestTC().typed() == "metaClass bar"
assert new TestTC().compiled() == "bar"

