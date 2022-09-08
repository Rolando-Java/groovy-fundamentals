package com.thererolando.groovybasics.test;

public class App {

    public static void main(String... args) {
        // OPERACIONES CON TIPO DE DATOS
        byte by1 = 1;
        byte by2 = 2;
        short sh1 = 1;
        short sh2 = 2;
        int in1 = 1;
        int in2 = 2;
        long lo1 = 1;
        long lo2 = 2;
        float fl1 = 1;
        float fl2 = 2;
        double do1 = 1;
        double do2 = 2;

        // Operaciones con mismo tipo de dato
        // Addition
        var sum1 = by1 + by2; // int
        System.out.println("sum1 = " + sum1); // 3
        var sum2 = sh1 + sh2; // int
        System.out.println("sum2 = " + sum2); // 3
        var sum3 = in1 + in2; // int
        System.out.println("sum3 = " + sum3); // 3
        var sum4 = lo1 + lo2; // long
        System.out.println("sum4 = " + sum4); // 3
        var sum6 = fl1 + fl2; // float
        System.out.println("sum6 = " + sum6); // 3.0
        var sum7 = do1 + do2; // double
        System.out.println("sum7 = " + sum7); // 3.0

        // Subtract
        var res1 = by2 - by1; // int
        System.out.println("res1 = " + res1); // 1
        var res2 = sh2 - sh1; // int
        System.out.println("res2 = " + res2); // 1
        var res3 = in2 - in1; // int
        System.out.println("res3 = " + res3); // 1
        var res4 = lo2 - lo1; // long
        System.out.println("res4 = " + res4); // 1
        var res6 = fl2 - fl1; // float
        System.out.println("res6 = " + res6); // 1.0
        var res7 = do2 - do1; // double
        System.out.println("res7 = " + res7); // 1.0

        // Multiplication
        var mul1 = by1 * by2; // int
        System.out.println("mul1 = " + mul1); // 2
        var mul2 = sh1 * sh2; // int
        System.out.println("mul2 = " + mul2); // 2
        var mul3 = in1 * in2; // int
        System.out.println("mul3 = " + mul3); // 2
        var mul4 = lo1 * lo2; // long
        System.out.println("mul4 = " + mul4); // 2
        var mul6 = fl1 * fl2; // float
        System.out.println("mul6 = " + mul6); // 2.0
        var mul7 = do1 * do2; // double
        System.out.println("mul7 = " + mul7); // 2.0

        // Division
        var div1 = by1 / by2; // int
        System.out.println("div1 = " + div1); // 0
        var div2 = sh1 / sh2; // int
        System.out.println("div2 = " + div2); // 0
        var div3 = in1 / in2; // int
        System.out.println("div3 = " + div3); // 0
        var div4 = lo1 / lo2; // long
        System.out.println("div4 = " + div4); // 0
        var div6 = fl1 / fl2; // float
        System.out.println("div6 = " + div6); // 0.5
        var div7 = do1 / do2; // double
        System.out.println("div7 = " + div7); // 0.5

        // Rest
        var rest1 = by1 % by2; // int
        System.out.println("rest1 = " + rest1); // 1
        var rest2 = sh1 % sh2; // int
        System.out.println("rest2 = " + rest2); // 1
        var rest3 = in1 % in2; // int
        System.out.println("rest3 = " + rest3); // 1
        var rest4 = lo1 % lo2; // long
        System.out.println("rest4 = " + rest4); // 1
        var rest6 = fl1 % fl2; // float
        System.out.println("rest6 = " + rest6); // 1.0
        var rest7 = do1 % do2; // double
        System.out.println("rest7 = " + rest7); // 1.0

        // Operaciones con diferente tipo de datos
        // Addition
        var sum9 = by1 + sh1; // int
        System.out.println("sum9 = " + sum9); // 2
        var sum10 = sh1 + in1; // int
        System.out.println("sum10 = " + sum10); // 2
        var sum11 = in1 + lo1; // long
        System.out.println("sum11 = " + sum11); // 2
        var sum12 = lo1 + fl1; // float
        System.out.println("sum12 = " + sum12); // 2.0
        var sum14 = fl1 + do1; // double
        System.out.println("sum14 = " + sum14); // 2.0

        // Subtract
        var res9 = by2 - sh1; // int
        System.out.println("res9 = " + res9); // 1
        var res10 = sh2 - in1; //int
        System.out.println("res10 = " + res10); // 1
        var res11 = in2 - lo1; // long
        System.out.println("res11 = " + res11); // 1
        var res12 = lo2 - fl1; // float
        System.out.println("res12 = " + res12); // 1.0
        var res14 = fl2 - do1; // double
        System.out.println("res14 = " + res14); // 1.0

        // Multiplication
        var mul9 = by1 * sh1; // int
        System.out.println("mul9 = " + mul9); // 1
        var mul10 = sh1 * in1; // int
        System.out.println("mul10 = " + mul10); // 1
        var mul11 = in1 * lo1; // long
        System.out.println("mul11 = " + mul11); // 1
        var mul12 = lo1 * fl1; // float
        System.out.println("mul12 = " + mul12); // 1.0
        var mul14 = fl1 * do1; // double
        System.out.println("mul14 = " + mul14); // 1.0

        // Division
        var div9 = by1 / sh2; // int
        System.out.println("div9 = " + div9); // 0
        var div10 = sh1 / in2; // int
        System.out.println("div10 = " + div10); // 0
        var div11 = in1 / lo2; // long
        System.out.println("div11 = " + div11); // 0
        var div12 = lo1 / fl2; // float
        System.out.println("div12 = " + div12); // 0.5
        var div14 = fl1 / do2; // double
        System.out.println("div14 = " + div14); // 0.5

        // Rest
        var rest9 = by1 % sh2; // int
        System.out.println("rest9 = " + rest9); // 1
        var rest10 = sh1 % in2; // int
        System.out.println("rest10 = " + rest10); // 1
        var rest11 = in1 % lo2; // long
        System.out.println("rest11 = " + rest11); // 1
        var rest12 = lo1 % fl2; // float
        System.out.println("rest12 = " + rest12); // 1.0
        var rest14 = fl1 % do2; // double
        System.out.println("rest14 = " + rest14); // 1.0

        new B().imprimir2();
    }

}

class A {

    public int age = 1;

    public void imprimir() {
        System.out.println("age = " + this.age);
    }

}

class B extends A {

    public int age = 2;

//    @Override
    public void imprimir2() {
        System.out.println("age = " + super.age);
        this.imprimir();
    }

}