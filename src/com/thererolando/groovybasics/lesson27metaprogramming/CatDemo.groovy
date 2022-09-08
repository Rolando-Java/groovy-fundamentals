package com.thererolando.groovybasics.lesson27metaprogramming

import groovy.time.TimeCategory

use(StringCategory) {
    println 'Hello, World!'.shout() // HELLO, WORLD!
}

use(TimeCategory) {
    println 1.minute.from.now // Sun Aug 14 15:43:32 PET 2022
    println 10.hours.ago // Sun Aug 14 05:42:32 PET 2022
    def someDate = new Date()
    println someDate - 3.months // Sat May 14 15:42:32 PET 2022
}


