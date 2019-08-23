package com.zyj.jfcs.app.ui.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
/**
 * 信息提示工具类
 * @author zhouyj
 *
 */
public class MessageUtils {
	
	/**
	 * 	打开小错误提示框
	 * @param shell
	 * @param title
	 * @param message
	 */
	public static void smallErrorMsgDialog(Shell shell, String title, String message) {
		MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		mb.setText(title);
		mb.setMessage(message);
		mb.open();
	}
	/**
	 * 	打开小错误提示框，使用当前的shell
	 * @param title
	 * @param message
	 */
	public static void smallErrorMsgDialog(String title, String message) {
		MessageBox mb = new MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
		mb.setText(title);
		mb.setMessage(message);
		mb.open();
	}
	
	
}
