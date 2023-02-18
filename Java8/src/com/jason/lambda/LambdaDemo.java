package com.jason.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FunctionalInterface
interface LambdaInterface {
	void f();
}

class LambdaClass{
	public LambdaClass(LambdaInterface l) {
		l.f();
	}
}

public class LambdaDemo {
	
	/**
	 * demo1 - demo3, 有一个共性
	 * 1. 可以用Lambda代替匿名内部类
	 * 2. 匿名内部类只需要重写一个方法（函数式接口）
	 */

	public void demo1() {
		/*
		 * new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The runable now is using!");
            }
		   }).start();
		 */
		new Thread(()->System.out.println("The runable now is using! It's a lambda")).start();
	}
	
	public void demo2() {
		List<Integer> strings = Arrays.asList(1, 2, 3);
		/*
		 *  
			Collections.sort(strings, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
			    return o1 - o2;}
			});
		 */
		Collections.sort(strings, (Integer o1, Integer o2) -> o2 - o1);
	}
	
	public void demo3() {
		new LambdaClass(() -> System.out.println("自定义函数式接口"));
	}
	
	/**
	 * demo4，在集合迭代中的运用
	 */
	public void demo4() {
		List<String> strings = Arrays.asList("1", "2", "3");
		/*
        传统foreach
        for (String s : strings) {
            System.out.println(s);
        }
        */
        strings.forEach((s) -> System.out.println(s));
        //or
//        strings.forEach(System.out::println);
 		
        //map
        Map<Integer, String> map = new HashMap<>();
        map.forEach((k,v)->System.out.println(v));
	}
}
