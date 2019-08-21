package com.zyj.jfcs.app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.hibernate.SessionFactory;

public class AppCache {
	
	public static Display DISPLAY;
	
	public static IWorkbenchWindow iWorkbenchWindow;
	
	/**
	 * Session 工厂
	 */
	public static SessionFactory sessionFactory;
	
}
