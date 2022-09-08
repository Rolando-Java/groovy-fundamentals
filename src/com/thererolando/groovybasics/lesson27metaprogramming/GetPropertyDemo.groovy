package com.thererolando.groovybasics.lesson27metaprogramming
/*
 El método getProperty(?) heredado de la clase GroovyObject, se invoca cada vez que intentas acceder
 valor de un atributo de clase.
 */
class GProperty {

    String prop1 = 'prop1'
    String prop2 = 'prop2'
    String prop3 = 'prop3'

    @Override
    Object getProperty(String propertyName) {
        println "getProperty() called with argument $propertyName"
        // evaluando su la propiedad existe
        if (this.metaClass.hasProperty(this, propertyName)) {
            return this.metaClass.getProperty(this, propertyName)
        }
        return 'part time'
    }
}

def pd = new GProperty()
assert pd.prop1 == 'prop1'
assert pd.prop2 == 'prop2'
assert pd.prop3 == 'prop3'
assert pd.prop4 == 'part time'

/*
 Si el método propertyMissing(?) es declarado en la clase, entonces se invocará cuando
 intentes acceder al valor de un atributo de clase y groovy no encuentre dicho atributo.
 */
class GPropertyDos {
    String prop1 = 'prop1'

    Object getProperty(String propertyName) {
        println "getProperty() called with argument $propertyName"
        this.metaClass.getProperty(this, propertyName)
    }

    def propertyMissing(String name) {
        "caught missing property $name"
    }
}

def pd2 = new GPropertyDos()
assert pd2.prop1 == 'prop1'
assert pd2.prop2 == 'caught missing property prop2'
