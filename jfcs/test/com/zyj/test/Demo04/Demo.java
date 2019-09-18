package com.zyj.test.Demo04;

public class Demo {
	public static void main(String[] args) {
//		System.out.println(Integer.valueOf(null));
//		System.out.println(Integer.parseInt(null));
		int i = 0;
		while(i < 10) {
			a(i++);
		}
	}
	
	public static void a(int i) {
		System.out.println(i);
	}
}
