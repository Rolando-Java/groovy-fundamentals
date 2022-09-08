package com.thererolando.groovybasics.lesson26groovybean.domain

import groovy.transform.ToString

@ToString
class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L

    String first
    String last
    String email

}
