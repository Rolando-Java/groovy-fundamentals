package com.thererolando.groovybasics.lesson4class

// create a instance of a developer
Developer developer = new Developer()
developer.first = 'Dan'
developer.last = 'Vega'

// assign some languages
developer.languages << 'Groovy'
developer.languages << 'Java'

// call some methods
developer.work()

