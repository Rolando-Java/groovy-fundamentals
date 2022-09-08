package com.thererolando.groovybasics.lesson2assertion

// you must provide an assertion an expression to true
assert true

// we can provide a full expression on the right hand side
// note that unlike Java and more like Ruby or Scala == is equality
assert 1 == 1

// like the example above we are evaluating an expression
def x = 1
assert x == 1

// what happens whe the expression doesn't evaluate to ture?
assert false

// The power assertion output show evaluation results from the outer to inner expression
assert 1 == 2

// complex debug output
assert 1 == (3 + 10) * 100 / 5 * 20

// the power assertion statements true unleashes in complex Boolean statements
// or statements with collections or other toString-enabled classes
def a = [1,2,3,4,5]
assert (a << 6) == [6,7,8,9,9,10]