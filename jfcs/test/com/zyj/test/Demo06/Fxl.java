package com.zyj.test.Demo06;

public class Fxl<T extends Number, B> {

	private T pt;
	
	private B pb;
	
	
	public T getPt() {
		return pt;
	}
	
	public void setPt(T t) {
		pt = t;
	}

	public Fxl(T pt, B pb) {
		super();
		this.pt = pt;
		this.pb = pb;
	}
	
	public static void main(String[] args) {
		Fxl<Integer, String> fxl = new Fxl<Integer, String>(123, "abc");
		Integer pt = fxl.getPt();
		
	}
	
	

}
