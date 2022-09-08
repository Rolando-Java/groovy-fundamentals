package com.thererolando.groovybasics.lesson27metaprogramming

/*
 El método setProperty(?,?) heredado de la clase GroovyObject, se invoca cada vez que intentas
 asignarle un valor al atributo de clase.
 */
class SProperty {
    String prop1

    @Override
    void setProperty(String propertyName, Object newValue) {
        println "setProperty() $propertyName $newValue"
        // evaluando si la propiedad existe
        if (this.metaClass.hasProperty(this, propertyName)) {
            this.metaClass.setProperty(this, propertyName, newValue)
        }
    }
}

def pd = new SProperty()
pd.prop1 = 'prop1'
assert pd.prop1 == 'prop1'
pd.prop2 = 'prop2'

/*
 El el método propertyMissing(?,?) es declarado en la clase. Entonces, se invocará cuando
 intentas asignar un valor al atributo de clase, pero groovy no logre encontrar dicho atributo.
 */
class SPropertyDos {
    String prop1

    @Override
    void setProperty(String propertyName, Object newValue) {
        println "setProperty() $propertyName $newValue"
        this.metaClass.setProperty(this, propertyName, newValue)
    }

    def propertyMissing(String name, def arg) {
        println "property: $name doesn't exist"
    }

}

def pd2 = new SPropertyDos()
pd2.prop1 = 'prop1'
assert pd2.prop1 == 'prop1'
pd2.prop2 = 'prop2'
