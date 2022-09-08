package com.thererolando.groovybasics.lesson6tipodedato

import groovy.transform.ToString

// GROOVY ES FULL POO
/*
 En groovy se usan las clases wrapper a cada rato, pese a que se usen tipos primitivos.
 Es por esa razón, que groovy es considerado un lenguaje full orientado a objetos.
 */
println 3.class.name // java.lang.Integer

// TIPOS DE DATOS EN GROOVY
def a = 1 as byte
def b = 1 as short
def c = 1
def d = 12345678912
def e = 123456789123456789123
def f = 0.1D
def g = 0.1F
def h = 0.1
def i = 0..9
def j = 'a'..'z'
def k = 'a' as char
def l = 'a'
def m = "a"
def n = "numero es : $a"
def ñ = []
def o = [:]

// TIPOS POR DEFECTO DE LOS LITERALES EN GROOVY
/*
 Tipo de dato por defecto de un número es integer, pero meditan vayas aumentando
 el número groovy será lo suficiente inteligente para saber que es un long el literal por defecto, o
 inclusive un BigInteger
 */
println 123456.class.name // java.lang.Integer
println 123456789123.class.name // java.lang.Long
println 123456789123456789123456789.class.name // java.math.BigInteger

/*
 Tipo de dato por defecto de un número decimal es BigDecimal
 */
println 1.0.class.name // java.lang.BigDecimal

/*
 Tipo por defecto de una cadena es String
 */
println 'a'.class.name // java.lang.String

// VALOR MÍNIMO Y MÁXIMO DE LOS TIPOS DE DATO

// byte
println "Min value: ${Byte.MIN_VALUE}" // -128
println "Max value: ${Byte.MAX_VALUE}" // 127

// short:
println "Min value: ${Short.MIN_VALUE}" // -32768
println "Max value: ${Short.MAX_VALUE}" // 32767

// integer
println "Min value: ${Integer.MIN_VALUE}" // -2147483648
println "Max value: ${Integer.MAX_VALUE}" // 2147483647

// long
println "Min value: ${Long.MIN_VALUE}" // -9223372036854775808
println "Max value: ${Long.MAX_VALUE}" // 9223372036854775807

// float
println "Min value: ${Float.MIN_VALUE}" // 1.4E-45
println "Max value: ${Float.MAX_VALUE}" // 3.4028235E38

// double
println "Max value: ${Double.MIN_VALUE}" // 4.9E-324
println "Min value: ${Double.MAX_VALUE}" // 1.7976931348623157E308

// INTRODUCCIÓN A LA GROOVY TRUTH
/*
 boolean: según la groovy Truth, el valor booleano no solo es true o false.
 Sino también puede ser, 0, 1, 0.0, 1.0, '', 'a', [], [1], [:], [name:'algo'], null
*/
boolean bool = true

/*
 En Java, se da un error de compilación cuando se le asigna un valor
 demasiado alto para lo que acepta el tipo de dato.
 En cambio en Groovy, se recorre como si fuera una recta numérica, la cantidad
 de dígitos desbordados, empezando de nuevo desde el valor mínimo que permite
 ese tipo de dato
 */
byte n1 = 129
println n1 // -127

int n2 = 2147483649
println n2 // -2147483647

// CONTROL DE DESBORDAMIENTO EN TIPO DE DATOS

/*
 En java esto debería dar un error de compilación, porque el literal por defecto
 de un numero es entero. Es decir, que el compilador al capturar el valor de la variable
 s1 y s2, estos valores son literales que por defecto es un integer; y un integer mas otro
 integer da integer, y como este tipo de dato en la escala es mucho mayor que short, el compilador te advertirá el error.
 Sin embargo, a Groovy, no le importa porque sabe que en caso de desbordamiento recorrerá tipo recta numérica,
 la cantidad de dígitos sobrantes desde el mínimo valor posible de este tipo de datos para arriba.

 */
short s1 = 123
short s2 = 123
short i3 = s1 + s2
println i3 // 246
println i3.class.name

/*
 Por esta razón, es que gracias a esto es que no te pedirá cast y podrás realizar operaciones
 con distintos tipos y pese a que el tipo de datos esté en una escala mayor, se podrá almacenar en un tipo
 de dato de menor escala, sin preocupación de desbordamiento, por parte del compilador
 */
BigDecimal d1 = 12.5
BigDecimal d2 = 12.6
float f1 = d1 + d2
println f1 // 25.1

// TIPO DE DATO DEF

/*
 En groovy, si es que no deseas especificar el tipo de datos, y dejar que el propio
 back de groovy se encargue.
 */

def def1 = 10
println def1.class.name // java.lang.Integer

/*
 Se puede observar que def es un dynamic typed. Es decir, que puedes
 asignarle un valor de diferente tipo a la variable
 */
def1 = 'cadena'
println def1.class.name // java.lang.String

/*
 OBS:
 Se recomienda que por buenas prácticas, si sabes el tipo de dato que será la variable,
 entonces debes definirlo, pero en caso no te importe saber el tipo de dato que recibe y quieres
 que groovy se encargue, entonces mejor usa el tipo de dato def; o tal vez en caso desees una variable
 al cual asignar un valor de diferente tipo, entonces mejor usa el tipo de dato def
 */

// OPERACIONES CON TIPO DE DATOS
byte by1 = 1
byte by2 = 2
short sh1 = 1
short sh2 = 2
int in1 = 1
int in2 = 2
long lo1 = 1
long lo2 = 2
BigInteger bi1 = 1
BigInteger bi2 = 2
float fl1 = 1
float fl2 = 2
double do1 = 1
double do2 = 2
BigDecimal bd1 = 1
BigDecimal bd2 = 2

// Operaciones con mismo tipo de dato
// Addition
def sum1 = by1 + by2 // Integer
println "sum1 = $sum1" // 3
println sum1.class.name
def sum2 = sh1 + sh2 // Integer
println "sum2 = $sum2" // 3
println sum2.class.name
def sum3 = in1 + in2 // Integer
println "sum3 = $sum3" // 3
println sum3.class.name
def sum4 = lo1 + lo2 // Long
println "sum4 = $sum4" // 3
println sum4.class.name
def sum5 = bi1 + bi2 // BigInteger
println "sum5 = $sum5" // 3
println sum5.class.name
def sum6 = fl1 + fl2 // Double
println "sum6 = $sum6" // 3.0
println sum6.class.name
def sum7 = do1 + do2 // Double
println "sum7 = $sum7" // 3.0
println sum7.class.name
def sum8 = bd1 + bd2 // BigDecimal
println "sum8 = $sum8" // 3
println sum8.class.name

// Subtract
def res1 = by2 - by1 // Integer
println "res1 = $res1" // 1
println res1.class.name
def res2 = sh2 - sh1 // Integer
println "res2 = $res2" // 1
println res2.class.name
def res3 = in2 - in1 // Integer
println "res3 = $res3" // 1
println res3.class.name
def res4 = lo2 - lo1 // Long
println "res4 = $res4" // 1
println res4.class.name
def res5 = bi2 - bi1 // BigInteger
println "res5 = $res5" // 1
println res5.class.name
def res6 = fl2 - fl1 // Double
println "res6 = $res6" // 1.0
println res6.class.name
def res7 = do2 - do1 // Double
println "res7 = $res7" // 1.0
println res7.class.name
def res8 = bd2 - bd1 // BigDecimal
println "res8 = $res8" // 1
println res8.class.name

// Multiplication
def mul1 = by1 * by2 // Integer
println "mul1 = $mul1" // 2
println mul1.class.name
def mul2 = sh1 * sh2 // Integer
println "mul2 = $mul2" // 2
println mul2.class.name
def mul3 = in1 * in2 // Integer
println "mul3 = $mul3" // 2
println mul3.class.name
def mul4 = lo1 * lo2 // Long
println "mul4 = $mul4" // 2
println mul4.class.name
def mul5 = bi1 * bi2 // BigInteger
println "mul5 = $mul5" // 2
println mul5.class.name
def mul6 = fl1 * fl2 // Double
println "mul6 = $mul6" // 2.0
println mul6.class.name
def mul7 = do1 * do2 // Double
println "mul7 = $mul7" // 2.0
println mul7.class.name
def mul8 = bd1 * bd2 // BigDecimal
println "mul8 = $mul8" // 2
println mul8.class.name

// Division
// Para groovy una división siempre devolverá el valor decimal de la división, sin importar
// que el dividendo y el cociente sean numero de tipo entero
def div1 = by1 / by2 // BigDecimal
println "div1 = $div1" // 0.5
println div1.class.name
def div2 = sh1 / sh2 // BigDecimal
println "div2 = $div2" // 0.5
println div2.class.name
def div3 = in1 / in2 // BigDecimal
println "div3 = $div3" // 0.5
println div3.class.name
def div4 = lo1 / lo2 // BigDecimal
println "div4 = $div4" // 0.5
println div4.class.name
def div5 = bi1 / bi2 // BigDecimal
println "div5 = $div5" // 0.5
println div5.class.name
def div6 = fl1 / fl2 // Double
println "div6 = $div6" // 0.5
println div6.class.name
def div7 = do1 / do2 // Double
println "div7 = $div7" // 0.5
println div7.class.name
def div8 = bd1 / bd2 // BigDecimal
println "div8 = $div8" // 0.5
println div8.class.name

// Rest
def rest1 = by1 % by2 // Integer
println "rest1 = $rest1" // 1
println rest1.class.name
def rest2 = sh1 % sh2 // Integer
println "rest2 = $rest2" // 1
println rest2.class.name
def rest3 = in1 % in2 // Integer
println "rest3 = $rest3" // 1
println rest3.class.name
def rest4 = lo1 % lo2 // Long
println "rest4 = $rest4" // 1
println rest4.class.name
def rest5 = bi1 % bi2 // BigInteger
println "rest5 = $rest5" // 1
println rest5.class.name
def rest6 = fl1 % fl2 // Double
println "rest6 = $rest6" // 1.0
println rest6.class.name
def rest7 = do1 % do2 // Double
println "rest7 = $rest7" // 1.0
println rest7.class.name
//def rest8 = bd1 % bd2 // Esta operación no es soportada por BigDecimal

// Operaciones con diferente tipo de datos
// Addition
def sum9 = by1 + sh1 // Integer
println "sum9 = $sum9" // 2
println sum9.class.name
def sum10 = sh1 + in1 // Integer
println "sum10 = $sum10" // 2
println sum10.class.name
def sum11 = in1 + lo1 // Long
println "sum11 = $sum11" // 2
println sum11.class.name
def sum12 = lo1 + bi1 // BigInteger
println "sum12 = $sum12" // 2
println sum12.class.name
def sum13 = bi1 + fl1 // Double
println "sum13 = $sum13" // 2.0
println sum13.class.name
def sum14 = fl1 + do1 // Double
println "sum14 = $sum14" // 2.0
println sum14.class.name
def sum15 = do1 + bd1 // Double
println "sum15 = $sum15" // 2.0
println sum15.class.name
def sum16 = fl1 + bd1 // Double
println "sum16 = $sum16" // 2.0
println sum16.class.name

// Subtract
def res9 = by2 - sh1 // Integer
println "res9 = $res9" // 1
println res9.class.name
def res10 = sh2 - in1 // Integer
println "res10 = $res10" // 1
println res10.class.name
def res11 = in2 - lo1 // Long
println "res11 = $res11" // 1
println res11.class.name
def res12 = lo2 - bi1 // BigInteger
println "res12 = $res12" // 1
println res12.class.name
def res13 = bi2 - fl1 // Double
println "res13 = $res13" // 1.0
println res13.class.name
def res14 = fl2 - do1 // Double
println "res14 = $res14" // 1.0
println res14.class.name
def res15 = do2 - bd1 // Double
println "res15 = $res15" // 1.0
println res15.class.name
def res16 = bd2 - fl1 // Double
println "res16 = $res16" // 1.0
println res16.class.name

// Multiplication
def mul9 = by1 * sh1 // Integer
println "mul9 = $mul9" // 1
println mul9.class.name
def mul10 = sh1 * in1 // Integer
println "mul10 = $mul10" // 1
println mul10.class.name
def mul11 = in1 * lo1 // Long
println "mul11 = $mul11" // 1
println mul11.class.name
def mul12 = lo1 * bi1 // BigInteger
println "mul12 = $mul12" // 1
println mul12.class.name
def mul13 = bi1 * fl1 // Double
println "mul13 = $mul13" // 1.0
println mul13.class.name
def mul14 = fl1 * do1 // Double
println "mul14 = $mul14" // 1.0
println mul14.class.name
def mul15 = do1 * bd1 // Double
println "mul15 = $mul15" // 1.0
println mul15.class.name
def mul16 = bd1 * fl1 // Double
println "mul16 = $mul16" // 1.0
println mul16.class.name

// Division
def div9 = by1 / sh2 // BigDecimal
println "div9 = $div9" // 0.5
println div9.class.name
def div10 = sh1 / in2 // BigDecimal
println "div10 = $div10" // 0.5
println div10.class.name
def div11 = in1 / lo2 // BigDecimal
println "div11 = $div11" // 0.5
println div11.class.name
def div12 = lo1 / bi2 // BigDecimal
println "div12 = $div12" // 0.5
println div12.class.name
def div13 = bi1 / fl2 // Double
println "div13 = $div13" // 0.5
println div13.class.name
def div14 = fl1 / do2 // Double
println "div14 = $div14" // 0.5
println div14.class.name
def div15 = do1 / bd2 // Double
println "div15 = $div15" // 0.5
println div15.class.name
def div16 = bd1 / fl2 // Double
println "div16 = $div16" // 0.5
println div16.class.name

// Rest
def rest9 = by1 % sh2 // Integer
println "rest9 = $rest9" // 1
println rest9.class.name
def rest10 = sh1 % in2 // Integer
println "rest10 = $rest10" // 1
println rest10.class.name
def rest11 = in1 % lo2 // Long
println "rest11 = $rest11" // 1
println rest11.class.name
def rest12 = lo1 % bi2 // BigInteger
println "rest12 = $rest12" // 1
println rest12.class.name
def rest13 = bi1 % fl2 // Double
println "rest13 = $rest13" // 1.0
println rest13.class.name
def rest14 = fl1 % do2 // Double
println "rest14 = $rest14" // 1.0
println rest14.class.name
def rest15 = fl1 % bd2 // Double
println "rest15 = $rest15" // 1.0
println rest15.class.name
def rest16 = fl1 % bd2 // Double
println "rest16 = $rest16" // 1.0
println rest16.class.name

// Conversion de tipos
assert 2 == 2.5.toInteger() // conversion
assert 2 == '2'.toInteger()
assert 2 == 2.5 as int // enforced coercion
assert 2 == (2.5 as Integer)
assert 2 == (int) 2.5 // cast

// times | upto | downto | step

20.times {
    print '-'
}

1.upto(10) { num ->
    println num
}

10.downto(1) { num ->
    println num
}

1.step(10, 1) { num ->
    println num
}

0.step(1.0, 0.1) { num ->
    println num
}

// Operadores sobrecargados
def num = 1
def num2 = 2
def resul1 = num.plus(num2)
println "resul1 = $resul1" // 3
def resul2 = num2.minus(num)
println "resul2 = $resul2" // 1
def resul3 = num.multiply(num2)
println "resul3 = $resul3" // 2
def resul4 = num.div(num2)
println "resul4 = $resul4" // 0.5
def resul5 = num.intdiv(num2)
println "resul5 = $resul5" // 0
def resul6 = num.mod(num2)
println "resul6 = $resul6" // 1
def resul7 = num.power(num2)
println "resul7 = $resul7" // 1
def resul8 = num.next()
println "resul8 = $resul8" // 2
def resul9 = num.previous()
println "resul9 = $resul9" // 0
def numbersList = [1,2,3,4]
def resul10 = numbersList.getAt(0)
println "resul10 = $resul10" // 0
def resul11 = numbersList.leftShift(5)
println "resul11 = $resul11" // [1,2,3,4,5]

/*
 Nosotros también podemos implementar estos método sobreescritos en nuestras propias
 clases, para de esta forma realizar operaciones con las instancias de nuestra clase
 */
@ToString
class Account {

    BigDecimal balance

    Account() {
       this.balance = 0
    }

    BigDecimal plus(Account other) {
       this.balance + other.balance
    }

}

Account savings = new Account(balance: 100.00)
Account checking = new Account(balance: 500.00)

println savings
println checking

BigDecimal balanceTotal = savings + checking
println "balanceTotal = $balanceTotal"





