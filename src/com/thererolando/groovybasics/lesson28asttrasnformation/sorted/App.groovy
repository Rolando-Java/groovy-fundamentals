package com.thererolando.groovybasics.lesson28asttrasnformation.sorted

Person p1 = new Person('Katie','Vega')
Person p2 = new Person('Dan','Vega')
Person p3 = new Person('Andy','Vega')
Person p4 = new Person('Joe','Vega')
Person p5 = new Person('Peter','NenVega')

List<Person> vegas = [p1,p2,p3,p4,p5]
println vegas.toSorted()
/*
 Usando los métodos comparator generados por @Sortable para el ordenamiento
 */
println vegas.toSorted(Person.comparatorByLast().thenComparing(Person.comparatorByFirst()))

