// Traits

/*
 Los traits son una construcción estructural del lenguaje que permite
 composición de comportamientos.
 Pueden verse como interfaces que llevan tanto implementaciones predeterminadas como state.
 */

/*
 - Los métodos de un trait son públicos por defecto
 */

trait A {
    String methodUno() {
        'method uno'
    }
}

class B implements A {}

A a = new B()
println a.methodUno()

/*
 - Los traits también pueden declarar métodos abstractos, los cuales
   deben implementarse en la clase que implemente el trait
 */

trait C {
    String methodUno() {
        'methoUno...'
    }

    abstract String methodDos()
}

class D implements C {
    @Override
    String methodDos() {
        'methodDos...'
    }
}

C c = new D()
println c.methodDos() // methodDos...

/*
 - Los rasgos también pueden definir métodos privados
 */

trait E {
    private String methodPriv() {
        'methodDos'
    }

    String methodDos() {
        this.methodPriv().concat('...')
    }
}

class F implements E {}

E e = new F()
println e.methodDos() // methodDos...

/*
 Propiedades en un Trait
 - Un trait puede definir propiedades, las cuales por defecto
   son privados, y tiene un getter y setter que sera heredado
   durante la implementación.
 */

trait G {
    String name = 'name'
}

class H implements G {

}

G g = new H()
g.name = 'other name'
println g.name // other name

/*
 Campos en un Trait
 - Un trait puede contener campos privados y públicos.
 */

trait I {
    public Integer countTot
    private Integer count = 0

    void count() {
        countTot = this.count + 1
    }
}

class J implements I {}

I i = new J()
i.count()
println i.I__countTot // 1

/*
 Un trait puede implementar varias interfaces y traits, haciendo
 uso de la clausula implements.
 */

interface K {
    String methodUno()
}

trait L {
    String methodDos() {
        'methodDos...'
    }
}

trait M implements K, L {
    String methodTres() {
        'methodTres...'
    }
}

class N implements M {
    @Override
    String methodUno() {
        'methodUno...'
    }
}

N n = new N()
println n.methodUno() // methodUno...
println n.methodDos() // methodDos...
println n.methodTres() // methodTres...

/*
 - Resolviendo conflicto de herencia para cuando
   dos métodos heredados tiene el mismo nombre.
 */

interface O {
    default String methodUno() {
        'methodUno O...'
    }
}

trait P {
    String methodUno() {
        'methodUno P...'
    }
}

class Q implements O, P {
    @Override
    String methodUno() {
        return O.super.methodUno()
    }
}

Q q = new Q()
println q.methodUno()

/*
 Implementando rasgos en tiempo de ejecución
 - Al obligar a un objeto a múltiples rasgos, el resultado de la operación no es la misma instancia.
   Se garantiza que el objeto forzado implementará tanto las características como las interfaces que
   implementa el objeto original, pero el resultado no será una instancia de la clase original.
 */

trait R {
    String methodUno() {
        'methodUno...'
    }
}

class S {}

S s = new S()
def s1 = s.withTraits R
println s1.methodUno() // methodUno...

/*
 Coerción tipo SAM
 - Si un trait define un único método abstracto, es candidato para la coerción de tipo SAM
   (Single Abstract Method).
 */

trait T {
    String greet() {
        "Hello $name"
    }

    abstract String getName()
}

/*
 Dado que getName() es el único método abstracto, el cierre
 se convierte en la implementación del getName
 */
T t = { 'Alice' }
println t.greet() // Hello Alice

void greet(T t) {
    println t.greet()
}

greet {
    'Alicia'
}
// Hello Alicia

/*
 - Los traits admiten el uso de métodos dinámicos
 */

trait U {
    def methodUno() {
        'methodUno...'
    }
}

class V implements U {}

U u = new V()
u.methodUno() // methodUno...

/*
 LIMITACIONES:
 - Los rasgos no son oficialmente compatibles con las transformaciones AST. Algunos de ellos,
   como @CompileStatic se aplicarán en el rasgo en sí (no en las clases de implementación), mientras
   que otros se aplicarán tanto en la clase de implementación como en el rasgo. No hay absolutamente
   ninguna garantía de que una transformación AST se ejecute en un rasgo como lo hace en una clase
   normal, ¡así que úsela bajo su propio riesgo!
 - El soporte de miembros estáticos en los trait es un trabajo en progreso y aún experimental.
 */































