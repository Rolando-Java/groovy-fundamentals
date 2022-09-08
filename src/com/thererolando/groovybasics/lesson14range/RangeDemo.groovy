package com.thererolando.groovybasics.lesson14range

import com.thererolando.groovybasics.test.practice.WeekDay

import java.time.LocalDate

// Rangos en Groovy

// rango de numeros
def r1 = 1..5
println r1.class.name // groovy.lang.IntRange
println "r1 = $r1" // [1,2,3,4,5]

// obteniendo el menor valor del rango
println r1.from // 1

// obteniendo el mayor valor del rango
println r1.to // 10

// rango de fechas
LocalDate today = LocalDate.now()
LocalDate oneWeekAway = today + 7

println "today = $today" // [2022-07-23]
println "oneWeekAway = $oneWeekAway" // [2022-07-30]

def days = today..oneWeekAway
println days.class.name // groovy.lang.ObjectRange
println "days = $days" // [2022-07-23, 2022-07-24, 2022-07-25, 2022-07-26,
                       // 2022-07-27, 2022-07-28, 2022-07-29, 2022-07-30]

//  rango de letras
def letters = 'a'..'e'
println "letters = $letters" // [a,b,c,d,e]

// rango de enums
def weekDays = WeekDay.MONDAY..WeekDay.WEDNESDAY
println "weekDays = $weekDays" // [MONDAY, TUESDAY, WEDNESDAY]

// Inclusion y Exclusion en los rangos
/*
 Para el excluir el elemento inicial o final del rango
 se hace uso de < , de lo contrario no usarlo.
 */
def inclRange = 0..5
assert inclRange == [0,1,2,3,4,5]
assert inclRange.from == 0
assert inclRange.to == 5

def exclEndRange = 0..<5
assert exclEndRange == [0,1,2,3,4]
assert exclEndRange.from == 0
assert exclEndRange.to == 4

def exclBeginRange = 0<..5
assert exclBeginRange == [1,2,3,4,5]
assert exclBeginRange.from == 1
assert exclBeginRange.to == 5

def exclRange = 0<..<5
assert exclRange == [1,2,3,4]
assert exclRange.from == 1
assert exclRange.to == 4

// validar si el elemento se encuentra en el rango
assert (0..10).contains(0)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false
assert (0..<10).contains(0)
assert (0..<10).contains(10) == false


