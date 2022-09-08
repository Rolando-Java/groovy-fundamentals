package com.thererolando.groovybasics.lesson21exception
// Exceptions

/*
 A diferencia de Java, en groovy las excepciones checked, no es
 necesario declararle un throws en el método para que propague la excepción.
 */

def foo() {
    // Se lanza una excepción checked
    throw new FileNotFoundException("The file isn't found")
}

def log = []

try {
    foo()
} catch (FileNotFoundException e) {
    log << e.message
} finally {
    log << 'finally'
}
println "log = $log"

class Account {
    BigDecimal balance

    Account() {
        this.balance = 0.0
    }

    def deposit(BigDecimal amount) {
        if (amount < 0) {
            throw new Exception("The amount mustn't be negative")
        }
        this.balance += amount
    }

    def deposit(List amounts) {
        amounts.each {
            this.deposit(it)
        }
    }

}

Account account = new Account()
account.deposit(100)
println "balance = ${account.balance}"

try {
    account.deposit(-100)
    println "balance = ${account.balance}"
} catch (Exception e) {
    System.err.println("Error: ${e.message}")
}

List amounts = [100, 200, 300]
account.deposit(amounts)
println "balance = ${account.balance}"














