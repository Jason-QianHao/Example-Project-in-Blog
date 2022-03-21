package com.jason.interfacedemo;

public interface Interface1 {
	
	static void sm() {
        System.out.println("Interface1提供的方式实现");
    }
    static void sm2() {
        System.out.println("Interface1提供的方式实现");
    }

    default void def() {
//    	this.def2();
        System.out.println("Interface1 default方法");
    }
    default void def2() {
    	this.def();
        System.out.println("Interface1 default2方法");
    }
    //须要实现类重写
    void f();
}
