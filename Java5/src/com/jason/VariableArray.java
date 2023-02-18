package com.jason;

public class VariableArray {

	public static void demo(int... array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		VariableArray.demo(1, 2, 3, 4);
	}
}
