package com.thererolando.groovybasics.lesson17closure

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString

import java.time.LocalDateTime
import java.time.ZoneId

// Closures en Groovy
/*
 Los closures no son métodos. Mas bien, son objetos, los cuales
 son instancias de la clase Closure
 */
def c = {}
println c.class.simpleName // _run_closure1
assert c instanceof Closure

/*
 Ejemplo de declaracion de un Closure
 */
def sayHelloUno = {
    println 'Hello'
}
/*
 Para invocar un closure, solo es necesario declarar el nombre
 del closure más el operador '()' y dentro ed estos paréntesis
 enviar valores de argumentos en caso hubiera.
 Ahora bien, cabe resaltar que por detrás el operador '()', es una
 sobrecarga del método call()
 */
sayHelloUno.call()
// otra forma de invocarlo, gracias al operador sobrecargado '()'
sayHelloUno()

/*
 Los closures tiene definido un parametro por defecto,
 el cual es 'it'
 */
def sayHelloDos = {
    println "Hello, $it"
}
sayHelloDos('Ana')

/*
 Nosotros podemos definir el nombre del parametro
 */
def sayHelloTres = { value -> println "Hello, $value"
}
sayHelloTres('Ana')

/*
 Podemos definir mas de un parametro
 */
def sayHelloCuatro = { name, age -> println "Hello, my name is $name and I'm $age years old"
}
sayHelloCuatro('Ana', 15)

/*
 Podemos definir el tipo de los parametros del Closure
 */
def sayHelloCinco = { String name, Integer age -> println "Hello, my name is $name and I'm $age years old"
}
sayHelloCinco('Ana', 15)

/*
 Podemos definir que un Closure no reciba parámetros, gracias
 al operador '->'
 */
def sayHelloSiete = { -> println 'Good morning!'
}
sayHelloSiete()

/*
 Podemos definir valores por defecto en los argumentos del Closure
 */
def greet = { String name, String greeting = 'Howdy' -> println "$greeting, $name"
}
greet('Matt', 'Hello') // Hello, Matt
greet('Luck') // Howdy, Luck

/*
 Podemos definir un vargars como parametro en un Closure y
 de esta forma no preocuparnos de la cantidad de parametros
 enviados
 */
def concat = { String... args -> args.join(",")
}
println concat('manzana', 'pera', 'platano')

/*
 Cuando declaras un método, puedes pasarle como parámetro un Closure,
 debido a que como se explicó anteriormente, son objetos
 */

def timesTen(Integer num, Closure closure) {
    closure(num * 10)
}

/*
 Cuando en un método declaras como parámetro final de este
 a un Closure, entonces no es necesario pasar el objeto closure
 dentro del paréntesis del método
 */
timesTen(2) { Integer n -> println n
}


/*
 La clase closure tiene metodo interesantes, por ejemplo:
 - maximumNumberOfParameters : te permite saber la cantidad de parametros que tiene
                               el Closure pasado
 - parameterTypes : te permite saber el tipo de cada parametro que tiene el Closure
 */

def someMethod(Closure c) {
    println "..."
    println c.maximumNumberOfParameters
    println c.parameterTypes
}

def someClosure = { Integer x, Integer y -> x + y
}

/*
 Ejemplo de uso de la anotacion @ClosureParams, el cual nos permite definir la
 cantidad y tipo de parametros del Closure.
 Además, recordar que para declarar el tipo de dato que devolvera el Closure, se lo
 debe definir como generico en la clase Closure.
 Ejemplo: Closure<Integer> ->  devolverá un tipo de datos Integer
 */

def powerNum(Integer num, @ClosureParams(value = FromString.class,
        options = ['Integer', 'Integer,Integer']) Closure<Integer> closure) {
    int countParameters = closure.maximumNumberOfParameters
    if (countParameters == 1) {
        return closure(num)
    }
    if (countParameters == 2) {
        return closure(num, num)
    }
    return 0
}

println powerNum(3) { a, b ->
    a**b
}

// Metodos Closure en colecciones
List favNums = [2, 21, 44, 35]

/*
 El metodo each() te permite recorrer los elementos de la lista
 */
favNums.each {
    println it
}

/*
 El metodo eachWithIndex() permite recorrer los elementos de la lista,
 pero a la vez te brinda un segundo parametro, el cual contiene el
 número de la posición de cada elemento recorrido
 */
favNums.eachWithIndex { int entry, int i ->
    println "$i:$entry"
}

def people = [
        [name:'Jane',city:'New York City'],
        [name:'John',city:'Cleveland'],
        [name:'Mary',city:'New York City'],
        [name:'Dan',city:'Cleveland'],
        [name:'Tom',city:'New York City'],
        [name:'Frank',city:'New York City'],
        [name:'Jason',city:'Cleveland']
]

/*
 El método find() permite filtrar mediante una condición los elementos de la lista.
 Este método retorna el primer elemento que cumpla la condición
 */
println people.find { person ->
    person.city == 'Cleveland'
}

/*
 El método findAll() permite filtrar mediante una condición los elementos de la lista.
 Este método retorna todos los elementos que cumplan la condición
 */
println people.findAll { person ->
   person.city == 'Cleveland'
}

/*
 El método any() devuelve un valor booleano.
 El resultado será true, siempre y cuando alguno de los elementos de la lista
 cumpla con la condición
 */
println people.any {person ->
    person.city == 'Cleveland'
}

/*
 El método every() devuelve un valor booleano.
 El resultado será true, siempre y cuando todos los elementos de la lista
 cumplan con la condición
 */
println people.every { person ->
    person.city == 'Cleveland'
}

/*
 El método groupBy() permite ordenar los miembros iterables, por el valor de alguna propiedad
 proporcionada en el closure
 */
def peopleByCity = people.groupBy {person ->
    person.city
}
println "peopleByCIty = $peopleByCity"

def newyorkers = peopleByCity.'New York City'
println "newyorkers = $newyorkers"

/*
 El método collect() permite iterar a través de esta colección transformando cada entrada en un
 nuevo valor utilizando Closure.IDENTITY como transformador, básicamente devolviendo una lista de
 elementos copiados de la colección original.
 */
List nums = [1, 2, 2, 7, 2, 8, 2, 4, 6]
List numsTimesTen = nums.collect { num -> num * 10 }

println nums // [1, 2, 2, 7, 7, 8, 2, 4, 6]
println numsTimesTen // [10, 20, 20, 70, 20, 80, 20, 40, 60]

// Uso de curry en Closure
def log = { String type, LocalDateTime createdOn, String msg ->
    println "$createdOn [$type] - $msg"
}

log('DEBUG', LocalDateTime.now(ZoneId.systemDefault()), 'This is my first debug statement...')

// curry
/*
 El metodo curry te permite crear un closure a partir de uno, pero ingresando
 los valores de los parametros de izquierda a derecha.
 */
def debugLog = log.curry("DEBUG")
debugLog(LocalDateTime.now(ZoneId.systemDefault()), 'This is one more...')

/*
 Incluso, puedes usar el metodo curry en closures que anteriomente
 fueron generados por un curry.
 */
def todayDebugLog = debugLog.curry(LocalDateTime.now(ZoneId.systemDefault()))
todayDebugLog("This is today's debug msg")

// right curry
/*
 El metodo rcurry te permite crear un closure a partir de uno, pero ingresando
 los valores de los parametros de derecha a izquierda.
 */
def crazyPersonLog = log.rcurry('Why am I logging this way')
crazyPersonLog('ERROR', LocalDateTime.now(ZoneId.systemDefault()))

// index based curry
/*
 El metodo ncurry te permite crear un closure a partir de uno, pero al ingresar
 el valor del parametro, debes especificar el indice del parametro al que le
 vas a ingresar el valor. Siendo la posicion 0, el primer parametro del closure
 */
def typeMsgLog = log.ncurry(1, LocalDateTime.now(ZoneId.systemDefault()))
typeMsgLog('ERROR', 'This is using ncurry...')

// This, Owner y Delegate en Closure
/*
 - this : se refiere a la instancia de la clase en la que se definió el Closure.
 - owner : es lo mismo que this, a menos que el Closure se haya definido dentro de otro Closure,
           en cuyo caso el owner se refiere al closure exterior.
 - delegate : por defecto, hace referencia a lo mismo que owner. Pero es el único que se puede
              cambiar programáticamente, y es el que hace que los Closures de Groovy sean
              realmente poderosos.
 */

// Ejemplo 1
class ScopeDemo {
    def outerClosure = {
        println this.class.name
        println owner.class.name
        println delegate.class.name
        def nestedClosure = {
            println this.class.name
            println owner.class.name
            println delegate.class.name
        }
        nestedClosure()
    }
}

ScopeDemo scopeDemo = new ScopeDemo()
scopeDemo.outerClosure()

/*
 Output:
 com.thererolando.groovybasics.lesson17closure.ScopeDemo
 com.thererolando.groovybasics.lesson17closure.ScopeDemo
 com.thererolando.groovybasics.lesson17closure.ScopeDemo
 com.thererolando.groovybasics.lesson17closure.ScopeDemo
 com.thererolando.groovybasics.lesson17closure.ScopeDemo$_closure1
 com.thererolando.groovybasics.lesson17closure.ScopeDemo$_closure1
 */

/*
 ¿Cómo Groovy resuelve la referencia message?
 Bueno es así. Si la variable no se definió explícitamente en el Closure, se verifica
 en el ámbito de THIS, seguido del ámbito de OWNER y por último intentar buscarlo en el
 ámbito de DELEGATE
 */

class MyClass {
    String message = 'Mensaje desde clase'
    def closure1 = {
        def closure2 = {
            println message
        }
        closure2()
    }
}

MyClass myClass = new MyClass()
Closure closure1 = myClass.closure1
closure1()

/*
 Output: Mensaje desde Clase
 En este caso Groovy, no encontró la referencia de message
 en el ámbito del mismo Closure, por lo que pasó a buscarlo en el ámbito de THIS.
 */

// Ejemplo 3
class MyClassDos {
    def closure1 = {
        String message = 'Mensaje desde closure 1'
        def closure2 = {
            println message
        }
        closure2()
    }
}

MyClassDos myClassDos = new MyClassDos()
closure1 = myClassDos.closure1
closure1()

/*
 Output: Mensaje desde Closure 1
 En este caso Groovy, no encontró la referencia de message
 en el ámbito del mismo Closure, tampoco lo encontró en el ámbito de THIS,
 pero si en el ámbito de OWNER
 */

// Ejemplo 4
class MyClassCuatro {
    String message = 'Mensaje desde clase cuatro'
}

class MyClassTres {
    def closure1 = {
        def closure2 = {
            println message
        }
        closure2()
    }
}

MyClassCuatro myClassCuatro = new MyClassCuatro()
MyClassTres myClassTres = new MyClassTres()
closure1 = myClassTres.closure1
closure1.delegate = myClassCuatro
closure1()

/*
 Output: Mensaje desde clase cuatro
 En este caso Groovy, no encontró la referencia de message
 en el ámbito del mismo Closure, tampoco lo encontró en el ámbito de THIS.
 Por otro lado, tampoco en el ámbito de OWNER, pero sí en el ámbito DELEGATE.
 El cual como se explicó anteriormente, pese a que debería ser igual que el ámbito de OWNER.
 En este caso, se le asignó como delegado a la clase MyClassTres, por lo que fue a buscar
 la existencia de message en dicha clase
 */

// Ejemplo 5
class MyClassSeis {
    String message = 'Mensaje desde clase seis'
}

class MyClassCinco {
    String message = 'Mensaje desde clase cinco'
    def closure1 = {
        def closure2 = {
            println message
        }
        closure2()
    }
}

MyClassCinco myClassCinco = new MyClassCinco()
MyClassSeis myClassSeis = new MyClassSeis()
closure1 = myClassCinco.closure1
closure1.delegate = myClassSeis
closure1()

/*
 Output: Mensaje desde clase cinco
 En este caso Groovy, no encontró la referencia de message
 en el ámbito del mismo Closure, pero si en el ámbito de THIS.
 Por otro lado también existe en el ámbito DELEGATE, el cual se explicó anteriormente
 su funcionamiento.
 Ahora bien en Groovy existen múltiples estrategias de resolución.

 - Closure.OWNER_FIRST : es la estrategia por defecto . Si existe una propiedad/método
                         en el propietario, se llamará al propietario. Si no, entonces
                         se usa el delegado.
 - Closure.DELEGATE_FIRST : invierte la lógica. Primero se usa el delegado, luego el propietario.
 - Closure.OWNER_ONLY : solo resolverá la búsqueda de propiedad/método en el propietario, el
                        delegado será ignorado.
 - Closure.DELEGATE_ONLY : solo resolverá la búsqueda de propiedad/método en el delegado.
                           Se ignorará al propietario.
 - Closure.TO_SELF : puede ser utilizado por desarrolladores que necesitan técnicas avanzadas de
                     metaprogramación y desean implementar una estrategia de resolución
                     personalizada. La resolución no se realizará en el propietario o el delegado,
                     sino solo en la propia clase de cierre. Solo tiene sentido usar esto si
                     implementa su propia subclase de Closure.

 Como la estrategia por defecto es Closure.OWNER_FIRST, entonces de tomará la propiedad message
 encontrada en el ámbito de THIS
 */

/*
 Pero si quisiéramos, podemos cambiar la estrategia implementada por defecto
 */
closure1.resolveStrategy = Closure.DELEGATE_FIRST
closure1()

/*
 Output: Mensaje desde clases seis
 Bueno, en este caso, al cambiar la estrategia a DELEGATE_FIRST. Groovy optó por usar
 la propiedad message encontrada en el ámbito DELEGATE de la clase MyClassSeis, en vez
 de usar la que encontró en el ámbito THIS de la clase MyClassCinco
 */
































