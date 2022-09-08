package com.thererolando.groovybasics.lesson28asttrasnformation.singleton

/*
 @Singleton, permite volver a una clase Singleton, es decir, cuya instancia
 se crea solo una vez y la misma instancia se usa en toda la aplicación.
 Esta anotación te brinda el atributo lazy, con el cual puedes indicar
 si se realizará de forma Early Loading o Lazy Loading
 */
@Singleton(lazy = true)
class DatabaseConnection {
}
