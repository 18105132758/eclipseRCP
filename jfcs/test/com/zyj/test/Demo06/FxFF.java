package com.zyj.test.Demo06;

import java.util.HashMap;
import java.util.Map;

public class FxFF {
	Map<String, Object> map = new HashMap<String, Object>();
	{
		map.put("name", 123);
	}
	/**
	 * Class<T> t 传递泛型类型，如果不设置这个参数，则返回类型由左值决定
	 */
	public <T> T fx(String s, Class<T> t) {
		return (T) map.get(s);
	}
	
	public static void main(String[] args) {
		new FxFF().fx("name", Integer.class);	//返回Integer类型
		new FxFF().fx("aa", Number.class);	//返回Number类型
	}
}
