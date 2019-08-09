package com.zyj.test.Demo02;

public class Demo01 {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(Demo01.class.getClassLoader().getResource(""));
		System.out.println(Demo01.class.getClassLoader().getResource("."));
		System.out.println(Demo01.class.getResource("/"));
		
		System.out.println(System.getProperty("java.class.path"));    //得到类路径和包路径
	}
}
