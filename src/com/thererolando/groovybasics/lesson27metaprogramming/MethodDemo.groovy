package com.thererolando.groovybasics.lesson27metaprogramming

/*
 El método invokeMethod(?,?) heredado de la clase GroovyObject es invocado cuando:
 - Groovy no encuentra el método que estás intentando llamar
 - No has declarado el método methodMissing(?,?) en la clase
 */
class InvokeMethodDemo {

    def test() {
        'method exists'
    }

    @Override
    Object invokeMethod(String name, Object args) {
        "called invokeMethod $name $args"
    }
}

def m = new InvokeMethodDemo()
assert m.test() == 'method exists'
assert m.someMethod() == 'called invokeMethod someMethod []'

/*
 Si el método methodMissing(?,?) es declarado en la clase. Entonces se invocará cuando
 Groovy no encuentre el método que estás intentando llamar.
 */
class MethodMissingDemo {

    @Override
    Object invokeMethod(String name, Object args) {
        "called invokeMethod $name $args"
    }

    def methodMissing(String name, def args) {
        "called methodMissing $name $args"
    }
}

def m2 = new MethodMissingDemo()
assert m2.someMethod() == 'called methodMissing someMethod []'

/*
 Se observa que el método invokeMethod(?,?) no es invocado, puesto que
 en la clase se encuentra declarado el método methodMissing(?,?)
 */
