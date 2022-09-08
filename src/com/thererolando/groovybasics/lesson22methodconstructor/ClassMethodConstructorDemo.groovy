package com.thererolando.groovybasics.lesson22methodconstructor


import groovy.transform.ToString

// Métodos en Groovy

/*
 Un método se define como un tipo de devolución o con la def clave, para que el tipo
 de devolución no tenga tipo

 - Si no se proporciona ningún modificador de acceso, el método es público
 - Si no se proporciona un return, se devolverá el valor evaluado en la última
   línea de ejecutada
 */

void firstMethod() {
    'first method called'
}

String secondMethod() {
    'second method called'
}

def thirdMethod() {
    'third method called'
}

static String fourthMethod() {
    'fourth method called'
}

static def fifthMethod() {
    'fifth method called'
}

this.firstMethod()
println this.secondMethod()
println this.thirdMethod()
println fourthMethod()
println fifthMethod()

/*
 Un método puede recibir parámetros que no tengan tipos declarados explícitamente
 */

def sixthMethod(param) {
    "$param passed"
}

def seventhMethod(String param) {
    "$param passed"
}

println sixthMethod('param')
println seventhMethod('param')

/*
 Argumentos predeterminados en los métodos.
 Es buena práctica declara los parámetros con valores por defecto
 al final del método
 */

def foo(String par1, Integer par2, BigDecimal par3 = 1, Double par4 = 1) {
    "$par1 $par2 $par3 $par4"
}

def foo(List par1 = [1, 2, 3], Boolean par2 = false) {
    "$par1 $par2"
}

println foo('A', 21, 10.0) // A 21 10.0 1.0
println foo([1]) // [1] false

/*
 Groovy admite métodos con un número variable de argumentos
 */

def fooArgs(Object... args) {
    args.length
}

Integer[] nums = [1, 2, 3]
assert fooArgs() == 0
assert fooArgs(1, 2) == 2
assert fooArgs('a', 'b', 'c') == 3
assert fooArgs(nums) == 3

/*
 Groovy permite T[] como una notación alternativa a T...
 */

def fooArgsDos(Object[] args) {
    args.length
}

assert fooArgsDos() == 0
assert fooArgsDos(1, 2, 3) == 3

/*
 Algoritmo de seleccion de metodo
 */

def someMethod(Object... args) {
    'o...'
}

def someMethod(Object o1, Object o2) {
    'o/o'
}

def someMethod(Integer i, String s) {
    'i/s'
}

def someMethod(String s, Integer i) {
    's/i'
}

assert someMethod(1, 2, 3, 4) == 'o...'
assert someMethod(1, 2) == 'o/o'
assert someMethod(1, 'a') == 'i/s'
assert someMethod('a', 1) == 's/i'

// Constructores en Groovy

/*
 Los constructores se utilizan para inicializar un objeto con un estado
 específico.

 - los constructores al igual que los métodos son públicos por defecto
 - es posible que una clase declare más de un constructor, siempre que cada
   constructor tenga una firma única.
 - Si no se proporciona constructores, el compilador Groovy proporcionará
   un constructor vacío sin argumentos.

 Groovy admite dos estilos de invocación:
 - Los parámetros posicionales se usan de manera a como sería los constructores en java
 - Los parámetros con nombre le permiten especificar nombres de parámetros al invocar
   al constructor.
 */

// Parámetros posicionales

@ToString
class PersonNoArgConstructor {
    String name
    Integer age
}

def person1 = new PersonNoArgConstructor()
println "person1 = $person1"

@ToString
class PersonConstructor {
    String name
    Integer age

    PersonConstructor(String name) {
        this.name = name
    }

    PersonConstructor(String name, Integer age) {
        this.name = name
        this.age = age
    }
}

def person2 = new PersonConstructor('susan')
def person3 = new PersonConstructor('lucas', 14)

/*
  Instanciando mediante coerción de listas.
  Siempre y cuando exista definido un constructor, en ese orden y tipo
  de parámetros.
 */
def person4 = ['michael'] as PersonConstructor
def person5 = ['luck', 21] as PersonConstructor
println "person2 = $person2"
println "person3 = $person3"
println "person4 = $person4"
println "person5 = $person5"

// Parámetros con nombre
/*
 Siempre y cuando exista un constructor sin argumentos. Ya sea porque no declaraste
 ningún constructor y groovy te proveyó un constructor si argumentos por defecto, o por otro lado,
 porque tu has declarado un constructor sin argumentos.
 Por otro lado si es que tienes declarado un constructor que recibe un mapa como parámetro
 o bien has hecho uso de la anotación @groovy.transform.MapConstructor
 */

@ToString
class PersonConstructorName {
    String name
    Integer age
}

def person6 = new PersonConstructorName(name: 'luck', age: 15)
def person7 = new PersonConstructorName(age: 21)
println "person6 = $person6"
println "person7 = $person7"
















