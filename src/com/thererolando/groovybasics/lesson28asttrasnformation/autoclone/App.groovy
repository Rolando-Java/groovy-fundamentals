package com.thererolando.groovybasics.lesson28asttrasnformation.autoclone

def p = new Person('John', 'Smith', ['ipod', 'shiraz'], new Date())
println "p = $p"
def p2 = p.clone()
println "p = $p"
println "p2 = $p2"

assert p instanceof Cloneable
assert p.favItems instanceof Cloneable
assert p.since instanceof Cloneable
assert !(p.first instanceof Cloneable)

assert p == p2
assert !p.is(p2)
assert p.first.is(p2.first)
assert !p.favItems.is(p2.favItems)
assert p.last.is(p2.last)
assert !p.since.is(p2.since)


