package com.zyj.test.Demo07;

import org.eclipse.swt.SWT;

public class TestLogic {
	public static void main(String[] args) {
		System.out.println(4 | 2);
		System.out.println(4 | 8);
		System.out.println(2 | 8);

		System.out.println(SWT.BORDER | SWT.HORIZONTAL);
		System.out.println(SWT.BORDER | SWT.VERTICAL);
		
		System.out.println(SWT.BORDER);
		System.out.println(SWT.HORIZONTAL);
		System.out.println(SWT.VERTICAL);
	}
}
