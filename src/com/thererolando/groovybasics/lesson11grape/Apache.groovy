package com.thererolando.groovybasics.lesson11grape

import org.apache.commons.lang3.StringUtils

@Grab(group = 'org.apache.commons', module = 'commons-lang3', version = '3.12.0')

/*
 StringUtils proporciona métodos para operaciones nulas seguras en cadenas
 */

/*
 valida que una subcadena este contenida en la cadena
 */
String cad1 = 'blaeldung'
assert StringUtils.contains(cad1, 'dung')

/*
 valida que la cadena contenga solo lo especificado, en otras palabras
 que su valor sea igual a los especificado en el método containsOnly
 */
assert !StringUtils.containsOnly(cad1, 'dung')

/*
 valida que una subcadena este contenida en la cadena, sin importar
 las mayúsculas o minúsculas
 */
assert StringUtils.containsIgnoreCase(cad1, 'DUNG')

/*
 cuenta cuántas veces aparece un carácter o subcadena en una cadena
 */
assert StringUtils.countMatches(cad1, 'l') == 2

/*
 El método appendIfMissing, agrega un sufijo al final de una cadena. Sin embargo, en caso la cadena
 ya termine en el sufijo pasado, entonces la cadena a devolver permanecerá igual.
 El método appendIfMissingIgnoreCase, agrega un sufijo al final de una cadena. Sin embargo, en caso la
 cadena ya termine en el sufijo pasado, entonces la cadena a devolver permanecerá igual. Pero, para
 averiguar si la cadena ya termina en el sufijo pasado, no le importará si está en mayúsculas o minúsculas
 a la hora de validar eso.
 */
assert StringUtils.appendIfMissing(cad1, 'G') == 'blaeldungG'
assert StringUtils.appendIfMissingIgnoreCase(cad1, 'G') == 'blaeldung'

/*
 El método prependIfMissing, agrega un prefijo al inicio de una cadena. Sin embargo, en caso la cadena
 ya inicie en el prefijo pasado, entonces la cadena a devolver permanecerá igual.
 El método prependIfMissingIgnoreCase, agrega un prefijo al inicio de una cadena. Sin embargo, en caso la
 cadena ya inicie en el prefijo pasado, entonces la cadena a devolver permanecerá igual. Pero, para
 averiguar si la cadena ya inicia en el prefijo pasado, no le importará si está en mayúsculas o minúsculas
 a la hora de validar eso.
 */
assert StringUtils.prependIfMissing(cad1, 'B') == 'Bblaeldung'
assert StringUtils.prependIfMissingIgnoreCase(cad1, 'B') == 'blaeldung'

/*
 convirtiendo una cadena en mayúsculas
 */
assert StringUtils.upperCase(cad1) == 'BLAELDUNG'

/*
 convirtiendo una cadena a minúsculas
 */
assert StringUtils.lowerCase(cad1) == 'blaeldung'

/*
 intercambia el caso de una cadena, cambiando mayúsculas a minúsculas y minúsculas a mayúsculas
 */
assert StringUtils.swapCase('BLAelDUNG') == 'blaELdung'

/*
 convierte el primer carácter de una cadena dada en mayúscula, dejando todos los caracteres
 restantes sin cambios.
 */
assert StringUtils.capitalize('ana carrIe') == 'Ana carrIe'

/*
 permite invertir la cadena
 */
assert StringUtils.reverse('blaeldung') == 'gnudlealb'

/*
 los caracteres se invierten en grupos en lugar de individualmente, mediante
 la definición de un delimitador específico
 */
assert StringUtils.reverseDelimited('www.blaeldung.com', '.' as char) == 'com.blaeldung.www'

/*
 permite repetir un carácter o cadena determinado, varias veces
 */
assert StringUtils.repeat('0', 3) == '000'















