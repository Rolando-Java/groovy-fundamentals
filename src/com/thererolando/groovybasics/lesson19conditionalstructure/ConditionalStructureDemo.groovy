package com.thererolando.groovybasics.lesson19conditionalstructure

// IF Statement

if (true) {
    println 'true'
}

if (true) println 'true'

def age = 35
if (age >= 35) {
    println 'can run for president'
}

if (true) {
    println 'true'
} else {
    println 'false'
}

def yourAge = 18
if (yourAge >= 21) {
    println 'buy beer'
} else {
    println 'no beer for you'
}

/*
 Se puede hacer uso del operador in, para
 validar que un elemento forme parte de una colección
 */
def someAge = 34
if (someAge in 21..<35) {
    println 'buy some beer'
} else if (someAge >= 35) {
    println 'run for president'
} else {
    println 'under 21'
}


// ternary operator (expression) ? true : false
def name = 'Dan'
def isItDan = (name.toUpperCase() == 'DAN') ? 'YES' : 'NO'
println "isItDan = $isItDan"

def msg = null
def output = (msg ? msg : 'default message')
def elvisOutput = (msg ?: 'default message')

println "msg = $msg"
println "output = $output"
println "elvisOutput = $elvisOutput"

// switch statement
// 1er ejemplo
char vocal = 'e'
switch (vocal) {
    case 'a':
        println 'is vocal a'
        break
    case 'e':
    case 'i':
        println 'si vocal e or i'
        break
    default:
        println 'is other vocal'
}

// 2do ejemplo
vocal = 'a'
switch (vocal) {
    case ~/[aeiou]/:
        println 'is a vocal'
        break
    default:
        println 'is non vocal'
}

// 3er ejemplo
def n1 = 2
def n2 = 3
def indOp = 3
def res = (switch (indOp) {
    case 0 -> n1 + n2
    case 1 -> n1 - n2
    case 2 -> n1 * n2
    case 3 -> {
        if (n2 != 0) {
            yield n1 / n2
        }
        yield 0
    }
    default -> 0
})
println "res = $res"

// 4to ejemplo
def num = 12
switch (num) {
    case 1:
        println '1'
        break
    case 2:
        println '2'
        break
    case 1..3:
        println 'in range 1..3'
        break
    case [1, 2, 12]:
        println 'num is in list [1,2,12]'
        break
    case Integer:
        println 'num is an Integer'
        break
    case Float:
        println 'num is a Float'
        break
    default:
        println 'default number'
}

// in
def validAges = 18..35
someAge = 19
println someAge in validAges













