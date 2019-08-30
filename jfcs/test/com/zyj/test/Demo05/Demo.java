package com.zyj.test.Demo05;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Demo {
	
	public static void main(String[] args) {
		new Demo().run();
	}
	
	
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("GC绘图示例");
		createContent(shell);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	
	
	public void createContent(Shell shell) {
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		//创建画板
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				Display display = Display.getCurrent();
				//设置背景色
				e.gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
				//设置前景色
				e.gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				//设置字体
				e.gc.setFont(new Font(display, "宋体", 27, SWT.NONE));
				//绘制文字
				e.gc.drawText("绘图测试程序", 5, 10);
				
				//设置绘制图形的背景色
				e.gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				/*
				 * 	绘制图形  
				 * 	在矩形内部画圆弧的边框线，矩形顶点坐标（50， 100）
				 * 	矩形宽-200，高-220，
				 * 	圆弧起始点 与 矩形中心连线  与OX正方向（3点钟方向）夹角——60度， 逆时针为正数，顺时针为负数
				  *    圆心角- 210度
				 */
				e.gc.drawArc(50, 100, 200, 220, 60, 210);
				//使用前景色填充图形
//				e.gc.fillArc(50, 100, 200, 220, 60, 210);
			}
		});
	}
}
