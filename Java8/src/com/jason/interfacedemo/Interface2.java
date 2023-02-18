package com.jason.interfacedemo;

public interface Interface2 {
	
	default void def() {
        System.out.println("Interface2 default方法");
    }
}
