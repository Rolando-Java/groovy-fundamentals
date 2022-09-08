package com.thererolando.groovybasics.lesson24interface
// Interfaces

/*
 Una interfaz define un contrato al que debe ajustarse una clase.
 Una interfaz solo define una lista de métodos que deben implementarse,
 pero no define la implementación del método.
 */

/*
 - Una interfaz solo define firmas de método
 - Los métodos de las interfaces son siempre públicos
 */

interface A {
    String methodUno()
}

/*
 - Una clase puede implementar una o varias interfaces con la
   palabra clave 'implements'
 */

class B implements A {

    @Override
    String methodUno() {
        'methodUno...'
    }

}

A a = new B()
println a.methodUno() // methodUno...
B b = a as B
println b.methodUno() // methodUno...

/*
 - Una interfaz puede extender de una o varias interfaces, inclusive de traits
 */
trait T {
    String methodTres()  {
        'methodTres...'
    }
}

interface C extends A,T {
    String methodDos()
}

class D implements C {

    @Override
    String methodUno() {
        'methodUno...'
    }

    @Override
    String methodDos() {
        'methodDos...'
    }

}

/*
 - Métodos por defecto en una interface
 - Resolviendo conflicto de igualdad en nombre de métodos
 */

interface E {
    default String methodUno() {
        'methodUno E...'
    }
}

interface F {
    default String methodUno() {
        'methodUno F...'
    }
}

class G implements E, F {
    @Override
    String methodUno() {
        E.super.methodUno()
    }
}

G g = new G()
println g.methodUno()

/*
 - Los atributos en una interface son constantes (public static final)
 */

interface H {
    String NAME = 'constant interface name'
}

println H.NAME // constant interface name

/*
 - Las interfaces admiten el uso de métodos dinámicos
 */

interface I {
    def methodUno()
}

class J implements I {
    @Override
    def methodUno() {
        return 'methodUno...'
    }
}

I i = new J()
println i.methodUno() // methodUno...






























