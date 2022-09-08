package com.thererolando.groovybasics.lesson4class

@groovy.transform.ToString
class Developer {

    String first
    String last
    def languages = []

    void work() {
       println "$first $last is working..."
        println "Learning the next languages: $languages"
    }

}
