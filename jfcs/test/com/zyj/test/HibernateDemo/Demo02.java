package com.zyj.test.HibernateDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class Demo02 {

	
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("GC绘图示例");
		
//		FileDialog fd = new FileDialog(new Display().getActiveShell(), SWT.SAVE);
//		String s = fd.open();
//		System.out.println(s);
		layout(shell);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
	}
	
	
	public static void layout(Shell shell) {
		shell.setLayout(new RowLayout());
		//创建主菜单
		Menu menuBar = new Menu(shell, SWT.BAR);
		
		//创建菜单项
		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("文件(&F)");  //指定快捷键为 ALT + F
		MenuItem editItem = new MenuItem(menuBar, SWT.CASCADE);
		editItem.setText("编辑(&E)");
		MenuItem helpItem = new MenuItem(menuBar, SWT.CASCADE);
		helpItem.setText("帮助(&H)");
		
		//创建“帮助”按钮子菜单
		Menu helpMenu = new Menu(menuBar);	//创建menuBar的子菜单
		helpItem.setMenu(helpMenu);		//为"帮助菜单项"设置子菜单
		//为“帮助”选项创建子菜单项
		MenuItem welcome = new MenuItem(helpMenu, SWT.NONE);
		welcome.setText("欢迎使用");
		
		welcome.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.SAVE);
				fd.setText("导出至Excel");
				fd.setFilterNames(new String[]{"*.xls", "*.*"});
				fd.setFilterPath("%userprofile%/MyDocuments");
				
//				fd.setFileName();
				String s = fd.open();
				System.out.println(s);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
//				FileDialog fd = new FileDialog(shell, SWT.SAVE);
//				String s = fd.open();
//				System.out.println(s);
				System.out.println("备选方法.............");
			}
		});
		
		new MenuItem(helpMenu, SWT.SEPARATOR);	//分割线
		MenuItem introItem = new MenuItem(helpMenu, SWT.CASCADE);
		introItem.setText("系统说明");
		
		Menu sysMenu = new Menu(helpMenu);
		introItem.setMenu(sysMenu);	//为“系统说明”设置子菜单
		MenuItem checkItem = new MenuItem(sysMenu, SWT.CHECK);
		checkItem.setText("Check(&H)");
		MenuItem radioItem = new MenuItem(sysMenu, SWT.RADIO);
		radioItem.setText("Radio(&H)");
		
		shell.setMenuBar(menuBar);	//为shell设置菜单栏
	}
	
}
