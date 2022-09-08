package com.thererolando.groovybasics.lesson28asttrasnformation.singleton

DatabaseConnection connection = DatabaseConnection.instance
println connection

DatabaseConnection connectionDos = DatabaseConnection.instance
println connectionDos

assert connection == connectionDos
