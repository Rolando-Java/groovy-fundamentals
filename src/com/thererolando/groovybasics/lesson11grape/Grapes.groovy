package com.thererolando.groovybasics.lesson11grape

import org.apache.commons.lang3.StringUtils

/*
 Grape es un administrador de dependencias JAR integrado en Groovy. Grape le permite agregar
 rápidamente dependencias del repositorio maven a sus classpath, lo que facilita aún más la
 creación de scripts.

 Es tan simple como agregar la anotación @Grab
 */
@Grab(group = 'org.apache.commons', module = 'commons-lang3', version = '3.12.0')

String name = 'daniel'
println "Capitalizando nombre: ${StringUtils.capitalize(name)}" // Daniel



