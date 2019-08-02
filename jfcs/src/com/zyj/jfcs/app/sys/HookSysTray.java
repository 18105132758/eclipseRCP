package com.zyj.jfcs.app.sys;
/**
 * 系统托盘，实现系统托盘对象的创建和管理
 * @author 周昱君
 *
 */

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.app.actions.LogOff;
import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

public class HookSysTray {
	
	/**
	 * 托盘项
	 */
	private TrayItem trayItem = null;
	/**
	 * 托盘图标
	 */
	private Image trayImage = null;
	
	
	public HookSysTray() {
		super();
	}
	
	public void createSysTray(final IWorkbenchWindow window) {
		initTrayItem(window);
		if(trayItem == null) {
			//构造弹出托盘菜单项
			trayPopupMenu(window);	
			//最小化窗口到托盘
			trayMinimize(window);
		}
	}
	
	/**
	 * 最小化程序到托盘
	 * @param window
	 */
	private void trayMinimize(IWorkbenchWindow window) {
		window.getShell().addShellListener(new ShellAdapter() {
			@Override
			public void shellIconified(ShellEvent e) {
				window.getShell().setVisible(false);	//窗口不可见：隐藏
			}
		});
		
		//用户单击托盘图标时使得主程序窗口可见并恢复为正常大小
		trayItem.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Shell shell = window.getShell();
				if(!shell.isVisible()) {
					//程序窗口隐藏时，显示窗口，并恢复正常大小
					shell.setVisible(true);
					//
					shell.setMinimized(false);
					
				}
			}
		});
	}

	/**
	 * 托盘弹出菜单
	 * @param window
	 */
	private void trayPopupMenu(IWorkbenchWindow window) {
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			@Override
			public void handleEvent(Event event) {
				//创建菜单管理器
				MenuManager manager = new MenuManager();
				//创建菜单
				Menu menu = manager.createContextMenu(window.getShell());
				//构造托盘项目弹出菜单
				fillTrayItem(manager, window);
				menu.setVisible(true);	//菜单可见
			}
			/**
			 * 构造托盘菜单项
			 * @param manager
			 * @param window
			 */
			private void fillTrayItem(MenuManager manager, IWorkbenchWindow window) {
				//创建退出系统菜单项
				Action exitSystem = new Action("退出系统[&E]", AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID,
						ImagePath.VIEW_EXIT_ITEM_ICO)) {
							@Override
							public void run() {
								//退出系统
								PlatformUI.getWorkbench().close();
							}
					
				};
				manager.add(new LogOff());	//增加用户注销菜单项
				manager.add(exitSystem);	//
			}
		});
	}

	/**
	 * 初始化托盘项目的文字和图标
	 * @param window
	 */
	private void initTrayItem(IWorkbenchWindow window) {
		//获取系统托盘对象
		Tray tray = window.getShell().getDisplay().getSystemTray();
		if(tray == null) {
			return;
		}
		
		//创建托盘项， 托盘项的parent就是托盘-Tray
		trayItem = new TrayItem(tray, SWT.NONE);
		//创建托盘图片
		trayImage = AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.VIEW_SYSTEM_TRAY_ITEM_ICO)
				.createImage();
		//设置图标
		trayItem.setImage(trayImage);
	}
	
	/**
	 * 销毁托盘相关资源
	 */
	public void dispose() {
		if(trayItem != null) {
			trayItem.dispose();
		}
		if(trayImage != null) {
			trayImage.dispose();
		}
	}
	/**
	 * 用户单击窗口最小化按钮的处理行为
	 * @param shell
	 */
	public void windowMinimized(Shell shell) {
		shell.setMinimized(true);	//最小化
		shell.setVisible(false);	//不可见
	}
}
