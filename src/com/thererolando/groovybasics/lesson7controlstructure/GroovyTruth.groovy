package com.thererolando.groovybasics.lesson7controlstructure

/*
 Groovy Truth
 Se debe tomar en cuenta que en Groovy, los expresiones
 también pueden ser evaluados como verdaderas o falsas
 */
println (0 ? 'verdadero' : 'falso')                 // falso
println (-1234 ? 'verdadero' : 'falso')             // verdadero
println (0.0 ? 'verdadero' : 'falso')               // falso
println (1.5 ? 'verdadero' : 'falso')               // verdadero
println ('' ? 'verdadero' : 'falso')                // falso
println ('cadena' ? 'verdadero' : 'falso')          // verdadero
println ([] ? 'verdadero' : 'falso')                // falso
println ([1] ? 'verdadero' : 'falso')               // verdadero
println ([:] ? 'verdadero' : 'falso')               // falso
println ([name:'lucas'] ? 'verdadero' : 'falso')    // verdadero
println (null ? 'verdadero' : 'falso')              // falso
println (false ? 'verdadero' : 'falso')             // falso
println (true ? 'verdadero' : 'falso')              // verdadero

