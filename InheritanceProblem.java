package com.java.programs;

    class A {
        public int i = 2;

        public void m1() {
            System.out.println("m1 from A");
        }
    }

    class B extends A {
        public int i = 3;

        public void m1() {
            System.out.println("m1 from B");
        }
    }

    class InheritanceProblem {

        public static void main(String[] args) {
            A a = new B();
            a.m1();

            System.out.println(a.i);
        }
    }
