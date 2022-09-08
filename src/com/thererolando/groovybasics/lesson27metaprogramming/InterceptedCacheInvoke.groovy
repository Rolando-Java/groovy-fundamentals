package com.thererolando.groovybasics.lesson27metaprogramming

// Intercept - Cache - Invoke Pattern

class Programmer {

    List<String> languages = []

    def methodMissing(String name, def args) {
        println "$name ($args) method was called"
        if(name.startsWithIgnoreCase('write')) {
            String language = name.split("write")[1]
            if(languages.contains(language)) {
                def impl = {Object[] theArgs ->
                    println "I like to write code in $language"
                }
                this.getMetaClass()."$name" = impl
                return impl(args)
            }
        }
        return null
    }

}

Programmer programmer = new Programmer()
programmer.languages << 'Groovy'
programmer.languages << 'Java'
println programmer.metaClass.methods.size()
programmer.writeGroovy()
programmer.writeGroovy()
programmer.writeGroovy()
println programmer.metaClass.methods.size()
programmer.writeJava()
programmer.writeJava()
println programmer.metaClass.methods.size()
