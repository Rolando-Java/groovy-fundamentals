package com.thererolando.groovybasics.lesson13expresionregular

/*
 Para obtener una instancia de tipo Pattern, solo se necesita usar
 el operador ~ . Y sumado a este operador, cualquier tipo de forma de cadena.
 Por ejemplo, todas estas formas devolverán un Pattern
 ~''
 ~""
 ~''''''
 ~""""""
 ~//

 Sin embargo, se recomienda usar el operador junto con //
 , ya que el slashy, permite realizar un escape automáticamente
 sobre el slash, el cual se usa muy a menudo en una expresión regular
 */
def pattern = ~/a\b/
println pattern.class // java.util.regex.Pattern

/*
 =~ define y retorna un matcher, el cual busca coincidencias con la expresión
 regular
 ==~ match operator, el cual busca una coincidencia exacta con la expresión regular.
  Es como si por detrás se le añadiera ^$ a la expresión.
  Además retorna un Booleano
 */
def text = 'Being a Cleveland Sports Fan is no way to go through life'
pattern = ~/Cleveland Sports Fan/
def finder = text =~ pattern
def matcher = text ==~ pattern

println finder // java.util.regex.Matcher[pattern=Cleveland Sports Fan region=0,57 lastmatch=]
println finder.size() // 1
println matcher // false

text = 'Cleveland Sports Fan'
pattern = ~/Cleveland Sports Fan/
matcher = text ==~ pattern
println matcher // true

// usando métodos en cuya sobrecarga se hace uso de Patterns
text = 'Being a Cleveland Sports Fan is no way to go through life'
pattern = ~/Cleveland/
text = text.replaceFirst(pattern, 'Buffalo')
println text // Being a Buffalo Sports Fan is no way to go through life

