package com.jason.java8.interfacedemo;

public interface Interface2 {
	
	default void def() {
        System.out.println("Interface2 default方法");
    }
}
