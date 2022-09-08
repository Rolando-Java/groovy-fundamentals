package com.thererolando.groovybasics.lesson15list

// Listas en Groovy

def list = [1, 2, 3, 4, 5]
println list.class.name // java.util.ArrayList
println "list = $list" // [1,2,3,4,5]

// En caso se quiera usar otro tipo de instancia ademas del ArrayList
list = [1, 2, 3, 4, 5] as LinkedList
println list.class.name // java.util.LinkedList

def nums = [1, 2, 5]
println "nums = $nums"

// Agregando elementos al inicio de la lista
nums.push(10)
println "nums = $nums" // [10,1,2,5]

/*
   Actualizando un elemento de la lista, por la posicion.
   Este operador es la sobrecarga de putAt()
 */
nums[1] = 4
println "nums = $nums" // [10,4,2,5]

/*
   Agrega un elemento o elementos a la lista, con el operador
   de la suma. Tambien, este devuelve la nueva lista modificada
   Este operador es la sobrecarga de plus()
 */
nums = nums + [7, 5]
println "nums = $nums" // [10,4,2,5,7,5]

/*
  Agregando un elemento a la lista
 */
nums.add(8)
println "nums = $nums" // [10,4,2,5,7,5,8]

/*
  Agregando un elemento a la lista.
  Este operador es la sobrecarga de leftShift()
 */
nums << 1
println "nums = $nums" // [10,4,2,5,7,5,8,1]

// Eliminando un elemento de la lista

/*
   Elimina el primer elemento de la lista, y luego lo devuelve
 */
def numDel = nums.pop()
println "numDel = $numDel" // 10
println "nums = $nums" // [4,2,5,7,5,8,1]

/*
   Elimina un elemento de la lista mediante el indice
 */
nums.removeAt(0)
println "nums = $nums" // [2,5,7,5,8,1]

/*
  Elimina un elemento o elementos de la lista mediante el
  operador de la resta. Además, este elimina cualquier ocurrencia
  del valor. Tambien, este devuelve la nueva lista
  modificada.
 */
nums = nums - 5
println "nums = $nums" // [2,7,8,1]

// Obteniendo elementos de la lista

/*
  Obteniendo un o varios elementos de la lista, mediante el operador
  []. Este operador es la sobrecarga de getAt()
 */
def n = nums[3]
println "n = $n" // 1

n = nums[1..3]
println "n = $n" // [7,8,1]

// Limpiando la lista

/*
   Nos permite deja la lista vacia
 */
nums.clear()
println "nums = $nums"

/*
  Al instancia una lista vacia de esta forma, tambien podemos
  limpiar la lista
 */
nums = []
println "nums = $nums"

// Loops en listas
nums = [1, 2, 3, 4, 5]
/*
 al recorrer la lista con la forma for - in, no es necesario
 declarar el tipo
 */
for (i in nums) {
    println i
}

// recorriendo mediante closure la lista
nums.each { println it }

// flatten
/*
  Si una lista contiene listas u otras colecciones
  dentro de si recursivamente. Con este metodo
  se uniran todos los elementos en una sola lista y por ende
  ya no habrá listas dentro de una lista.
 */
nums << [3, 4, 5]
nums << [1, 2]
println "nums = $nums" // [1, 2, 3, 4, 5, [3, 4, 5], [1, 2]]

nums = nums.flatten()
println "nums = $nums" // [1, 2, 3, 4, 5, 3, 4, 5, 1, 2]

/*
  Permite eliminar los elementos repetidos de la lista.
  Tomar en cuenta que si no quieres que modifique la
  instancia de la lista, mandar false.
 */
def elementsUnique = nums.unique(false)
println "elementsUnique = $elementsUnique" // [1,2,3,4,5]

/*
  Permite ordenar los elementos.
  Tomar en cuenta que si no quieres que modifique la instancia de
  la lista, mandar false.
 */
def elementsSorted = nums.sort(false, Comparator.reverseOrder())
println "elementsSorted = $elementsSorted" // [5,5,4,4,3,3,2,2,1,1]

/*
  Busca todos los elementos que cumplan con la condicion
 */
def elementsFind = nums.findAll {
    it >= 2
}
println "elementsFind = $elementsFind" // [2,3,4,5,3,4,5,2]

/*
  Busca el primer elemento que cumpla con la condicion
 */
def elementFind = nums.find {
    it >= 5
}
println "elementFind = $elementFind" // 5