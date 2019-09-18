package com.zyj.test.Demo06;

/**
 * SX1类没有指定具体的泛型类型，此时必须把SX1声明成泛型类，否则编译报错
 * @author zhouyj
 * @param <T>
 */
public class SX1<T> implements FxJK<T>{

	@Override
	public T genereate() {
		// TODO Auto-generated method stub
		return null;
	}
}
