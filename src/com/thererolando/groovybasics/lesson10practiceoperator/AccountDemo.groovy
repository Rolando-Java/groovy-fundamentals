package com.thererolando.groovybasics.lesson10practiceoperator


import groovy.transform.ToString

@ToString
class Account {
    BigDecimal balance
    String type

    Account() {
        this.balance = 0
    }

    BigDecimal deposit(BigDecimal value) {
        this.balance += value
    }

    BigDecimal withdraw(BigDecimal value) {
        this.balance -= value
    }

    BigDecimal plus(Account other) {
        this.balance + other.balance
    }

}

Account checking = new Account(type: 'Checking')
checking.deposit(100.00)
Account savings = new Account(type: 'Savings')
savings.deposit(50.00)

println checking
println savings

BigDecimal total = checking + savings
println "total = $total"


