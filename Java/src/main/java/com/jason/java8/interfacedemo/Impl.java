package com.jason.java8.interfacedemo;

public class Impl implements Interface1, Interface2{

	
	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

	// 因为Interface1和Interface2都有default def方法，这里同时实现，就需要进行重写。
	@Override
	public void def() {
		// TODO Auto-generated method stub
		Interface2.super.def();
	}
	
	public static void main(String[] args) {
		Impl impl = new Impl();
		impl.def2();
		System.out.println("-----------");
		impl.def();
		System.out.println("-----------");
		impl.f();
	}

}
