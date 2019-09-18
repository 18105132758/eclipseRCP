package com.zyj.test.Demo06;

/**
 * 	在实现FxJK时，为其指定了具体的泛型类型。
 * 	此时SX2不需要指定泛型参数，FxJK相关方法的泛型也会替换成具体的类型
 * @author zhouyj
 * @param <T>
 */
public class SX2 implements FxJK<String>{

	@Override
	public String genereate() {
		// TODO Auto-generated method stub
		return null;
	}
}
