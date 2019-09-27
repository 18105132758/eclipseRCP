package com.zyj.test.databinding;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class BindingDemo01 {
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("SWT Application");
		//初始化SWT控件
		Text text = new Text(shell, SWT.NONE);
		text.setBounds(80, 75, 100, 30);
		text.setEditable(true);
		//初始化实体类
		Person p = new Person();
		p.setName("abc");
		/**
		 * 	这里必须在Runnable编写绑定逻辑，创建IObservableValue实例；
		 * 	因为莫名原因，可能是没有配置Realm，直接在外部进行绑定，会报错。
		 */
		Realm.runWithDefault(DisplayRealm.getRealm(display), new Runnable() {
			@Override
			public void run() {
				//初始化DataBindingContext
				DataBindingContext ctx = new DataBindingContext();
				//为Text的text属性创建IObservableValue
				IObservableValue target = WidgetProperties.text(SWT.Modify).
						observe(text);
				//为Person的name属性创建IObservableValue
				@SuppressWarnings("unchecked")
				IObservableValue model= BeanProperties.value(Person.class,"name").observe(p);
			    //绑定属性
				ctx.bindValue(target, model);
				
				//关闭Text控件时，关闭DataBindingContext，也可以设置为在当前窗口关闭时，关闭DataBindingContext
				text.addDisposeListener(new DisposeListener() {
					@Override
					public void widgetDisposed(DisposeEvent e) {
						System.out.println("关闭Ctx");
						ctx.dispose();
					}
				});
			}
		});
		//创建工具栏，用于测试数据同步
		createGJL(shell, p);
		shell.open();
		shell.setLayout(new FillLayout());
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private static void createGJL(Shell shell, Person p) {
		ToolBar tb = new ToolBar(shell, SWT.TOP);
		ToolItem ti = new ToolItem(tb, SWT.PUSH);
		ti.setText("修改名称");
		ti.addSelectionListener(new SelectionAdapter() {
			int i = 0;
			@Override
			public void widgetSelected(SelectionEvent e) {
				p.setName(p.getName() + (i++));
			}
			
		});
	}
}
