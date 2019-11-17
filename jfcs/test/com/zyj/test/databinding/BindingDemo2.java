package com.zyj.test.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.sideeffect.ISideEffectFactory;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.swt.WidgetSideEffects;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class BindingDemo2 {
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
					ISWTObservableValue target = WidgetProperties.text(SWT.Modify).
				            observe(text);
					
					/*
					 * 	创建ISideEffect工厂： ISideEffect工厂是基于具体的控件创建的，
					 * 	所以ISideEffect工厂创建的所有ISideEffect实例，都具备相同的生命周期，一旦控件被销毁，
					 * 	则ISideEffect实例也被销毁
					 */
					ISideEffectFactory isf = WidgetSideEffects.createFactory(text);
					
					//实现Person.name  -> Text.text
			        isf.create(p::getName, text::setText);
			        //实现 Text.text -> Person.name
			        isf.create(target::getValue, p::setName);
				}
			});
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
				System.out.println(p.getName());
				p.setName(p.getName() + (i++));
			}
			
		});
	}
}
