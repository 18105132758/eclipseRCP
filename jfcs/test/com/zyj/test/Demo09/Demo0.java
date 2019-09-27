package com.zyj.test.Demo09;

import java.util.Calendar;
import java.util.Locale;

public class Demo0 {
	public static void main(String[] args) {
		
		  System.out.println("-----------------------我是微笑的分割线O(∩_∩)O哈哈~-----------------------------");
		    System.out.println("这是格式化时间相关的，具体输出跟你执行代码时间有关");
		    Calendar calendar = Calendar.getInstance();
		    System.out.println(String.format("'B':本地化显示月份字符串，如：January、February"));
		    System.out.println(String.format("'b':本地化显示月份字符串的缩写，如：Jan、Feb"));
		    System.out.println(String.format("'h':本地化显示月份字符串的缩写，效果同'b'"));
		    System.out.println(String.format(Locale.US, "Locale.US 月份=%1$tB，缩写=%1$tb", calendar));
		    System.out.println(String.format(Locale.CHINA, "Locale.CHINA 月份=%1$tB，缩写=%1$tb", calendar));

		    System.out.println(String.format("'A':本地化显示星期几字符串，如：Sunday、Monday"));
		    System.out.println(String.format("'a':本地化显示星期几字符串的缩写，如：Sun、Mon"));
		    System.out.println(String.format(Locale.US, "Locale.US 星期几=%1$tA，缩写=%1$ta", calendar));
		    System.out.println(String.format(Locale.CHINA, "Locale.CHINA 星期几=%1$tA，缩写=%1$ta", calendar));

		    System.out.println(String.format("'C':年份除以100的结果，显示两位数，不足两位前面补0：%tC（范围：00-99）", calendar));
		    System.out.println(String.format("'Y':显示四位数的年份，格利高里历，即公历。不足四位前面补0：%tY", calendar));
		    System.out.println(String.format("'y':显示年份的后两位：%ty（范围：00-99）", calendar));
		    System.out.println(String.format("'j':显示当前公历年的天数：第%tj天（范围：001-366）", calendar));
		    System.out.println(String.format("'m':显示当前月份：%tm月（范围：01-13？怎么会有13个月？）", calendar));
		    System.out.println(String.format("'d':显示是当前月的第几天，不足两位前面补0：%1$tm月第%1$td天（范围：01-31）", calendar));
		    System.out.println(String.format("'e':显示是当前月的第几天：%1$tm月第%1$te天（范围：1-31）", calendar));
	}
}
