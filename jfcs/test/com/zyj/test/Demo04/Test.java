package com.zyj.test.Demo04;

public enum Test {
	A("你好"),
	B("我好");
	private String msg;

	private Test(String m) {
		this.msg = m;
	}

	@Override
	public String toString() {
		return msg;
	}
	
	public static void main(String[] args) {
		System.out.println(Test.valueOf("A"));
		System.out.println(Test.valueOf(Test.class, "我好"));
		System.out.println(Test.valueOf("你好"));
	}
	
	
	
}
