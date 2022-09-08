package com.thererolando.groovybasics.lesson27metaprogramming

// Expando class
/*
 La clase Expando es una especie de bean dinámico. Podemos agregar propiedades y podemos
 agregar cierres como métodos a una instancia de la Expando clase. Eso es útil si no
 queremos crear una nueva clase para un bean simple.
 */
def e = new Expando()
// agregando propiedad
e.name = 'Dan'

// agregando closure como método
e.writeCode = { ->
    println "${name} loves to write code"
}
e.writeCode()

// Uso de MetaClass
/*
 Groovy proporciona una propiedad metaClass en todas sus clases. Además esta propiedad
 implementa la interface ExpandoMetaClass. Es decir, que gracias a esto, podemos usar
 la propiedad metaClass para agregar propiedades y métodos a una clase, en tiempo de ejecución.
 */
class Developer {}

// instanciando la clase GroovyObjectDemo
def dev = new Developer()

// agregando propiedad mediante el atributo metaClass
dev.metaClass.name = 'Dan'
// agregando closure como método mediante el atributo metaClass
dev.metaClass.writeCode = { -> "$name loves to write code" }
dev.writeCode()

/*
 Si deseas que el atributo y método agregado se refleje en todas
 las intancias de la clase, entonces debes hacerlo de forma estática.
 */
Developer.metaClass.lastname = 'Richard'

def dev2 = new Developer()
println dev2.lastname // Richard

// Aplicando la teoría con la clase String
String.metaClass.upper = { -> toUpperCase() }
println 'luck'.upper() // LUCK

float n = 1F
BigDecimal n2 = 1
def n3 = n * n2
println n3.class.name


