package com.thererolando.groovybasics.lesson20loopingstructure
// while statement
def cont = 0
UNO:
do {
    cont++
    if (cont % 2 != 0) {
        continue UNO
    }
    println cont
    if (cont >= 10) {
        break UNO
    }
} while (true)


// for statement
println 'for statement'

def nums = [1, 2, 3, 4]
for (int i = 0; i < nums.size(); i++) {
    println "nums = ${nums[i]}"
}

for (int num : nums) {
    println "num = $num"
}

/*
 Con el operador in , no es necesario indicar el tipo de dato
 */
for (num in nums) {
    println "num = $num"
}

nums.each { num -> println "num = $num" }
nums.eachWithIndex { int num, int i -> println "num[$i] = $num" }

10.times { num ->
    println "num = $num"
}

1.upto(10) { num ->
    println "num = $num"
}

10.downto(1) { num ->
    println "num = $num"
}

0.step(10, 2) { num ->
    println "num = $num"
}

0.step(1, 0.2) { num ->
    println "num = $num"
}











