package com.thererolando.groovybasics.lesson7controlstructure

// if/else statement
println 'if-else statement'
int x = 5
if(x == 10) {
    println 'x is 10'
} else if(x <= 9 && x >=2) {
    println 'x is between 2 and 9'
} else {
    println 'X is 1'
}

// while statement
println 'while statement'
int i = 10
while(i) {
    println i--
}

i = 10
//do-while statement
println 'do-while statement'
do {
    println i--
} while(i)

// for statement
println 'for statement'
List list = [1,2,3,4]
for(int j = 0; j < list.size(); j++) {
    println list[j]
}

for(int num : list) {
   println num
}

for(int num in list) {
    println num
}

for(num in list) {
    println num
}
list.forEach(num -> println num)
list.each {println it}

// switch statement
println 'switch statement'
int myNumber = 1
switch(myNumber) {
    case 1:
        println 'number is 1'
        break
    default:
        println 'number is 2'
}