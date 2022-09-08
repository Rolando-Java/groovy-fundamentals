package com.thererolando.groovybasics.lesson26groovybean.domain;

import java.io.Serial;
import java.io.Serializable;

public class EmployeeBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // private properties
    private String first;
    private String last;
    private String email;

    // getters & setters
    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "first = " + this.first + " last = " + this.last + " email = " + this.email;
    }

}
