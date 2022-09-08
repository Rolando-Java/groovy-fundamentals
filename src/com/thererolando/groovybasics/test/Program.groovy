package com.thererolando.groovybasics.test

import com.thererolando.groovybasics.test.practice.WeekDay
import groovy.transform.Canonical

@groovy.transform.Canonical
class Person implements Comparable<Person> {
    String name
    Integer edad

    Integer plus(Person other) {
        this.edad + other.edad
    }

    Person next() {
        println 'entro al next'
        new Person(name: this.name, edad: this.edad + 1)
    }

    Person previous() {
        println 'entro al previous'
        new Person(name: this.name, edad: this.edad - 1)
    }

    @Override
    int compareTo(Person o) {
        this.edad <=> o.edad
    }

}

Person person1 = new Person(name: 'mateo', edad: 12)
Person person2 = new Person(name: 'luck', edad: 20)

def edad = person1 + person2
println "edad = $edad"

person1++
println "person1 = $person1"

person1--
println "person1 = $person1"

def personRange = person1..person2
println "personRange = $personRange"

personRange = person2..person1
println "personRange = $personRange"

WeekDay monday = WeekDay.MONDAY
println "monday = $monday"

def weekDayRange = WeekDay.MONDAY..WeekDay.FRIDAY
println "The size of the range is : ${weekDayRange.size()}"
assert weekDayRange.contains(WeekDay.WEDNESDAY)
println "Element from is : ${weekDayRange.from}"
println "Element to is : ${weekDayRange.to}"

def days = WeekDay.values().toList()
println "days : $days"
println "The size of the list is ${days.size()}"
println days.remove(WeekDay.SATURDAY)
println "days : $days"
days << WeekDay.SATURDAY
println "days : $days"
println days[days.indexOf(WeekDay.WEDNESDAY)]

def daysMap = [1: WeekDay.MONDAY, 2: WeekDay.TUESDAY, 3: WeekDay.WEDNESDAY,
               4: WeekDay.THURSDAY, 5: WeekDay.FRIDAY, 6: WeekDay.SATURDAY, 7: WeekDay.SUNDAY]
println "daysMap = $daysMap"
println daysMap.getClass().name
println "The size of map is ${daysMap.size()}"
println daysMap.values()

/*
 Ejemplo de como personalizar tu propia clase, para
 poder aplicar rangos con este
 */

@Canonical
class Nota implements Comparable<Nota> {
    Integer value

    Nota previous() {
        new Nota(value - 1)
    }

    Nota next() {
        new Nota(value + 1)
    }

    @Override
    int compareTo(Nota o) {
        this.value <=> o.value
    }

}

Nota nota = new Nota(15)
nota++
println "notaPrevious = $nota" // Nota(16)
nota--
println "nota = $nota" // Nota(15)

Nota notaStart = new Nota(18)
Nota notaEnd = new Nota(20)
def notas = notaStart..notaEnd
println "The list of range is ${notas.size()}" // 3
println "notas = ${notas}" // [Nota(18),Nota(19),Nota(20)]
println "from = ${notas.from}" // Nota(18)
println "to = ${notas.to}" // Nota(20)

def myMethod(Closure<Void> closure) {
    closure()
}

def foo = { ->
    println 'foo...'
}

myMethod(foo)

List names = ['Dan Vega', 'Joe Vega', 'Andy Vega', 'Katie Vega']
names.each {name ->
    println name
}

Map teams = [baseball:'Cleveland Indians',basketball:'Cleveland Cavs',football:'Cleveland Browns']
teams.each {key, value ->
   println "$key:$value"
}

def greet = {String greeting, String name ->
    println "$greeting , $name"
}

greet('Hello', 'Dan')

def sayHello = greet.curry('Hello')
sayHello('Joe')

def people = [
        [name:'Jane',city:'New York City'],
        [name:'John',city:'Cleveland'],
        [name:'Mary',city:'New York City'],
        [name:'Dan',city:'Cleveland'],
        [name:'Tom',city:'New York City'],
        [name:'Frank',city:'New York City'],
        [name:'Jason',city:'Cleveland']
]

println people.find { person ->
    person.city == 'Cleveland'
}
println people.findAll { person ->
   person.city == 'Cleveland'
}

println people.any {person ->
    person.city == 'Cleveland'
}
println people.every { person ->
    person.city == 'Cleveland'
}

def peopleByCity = people.groupBy {person ->
    person.city
}
println "peopleByCIty = $peopleByCity"

def newyorkers = peopleByCity.'New York City'
def clevelanders = peopleByCity.Cleveland
println "newyorkers = $newyorkers"
println "clevelanders = $clevelanders"














