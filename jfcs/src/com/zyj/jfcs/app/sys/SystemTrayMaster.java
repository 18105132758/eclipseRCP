package com.zyj.jfcs.app.sys;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

public class SystemTrayMaster implements SelectionListener, Listener{
	/**
	 * 内部类，负责从最小化 还原窗口
	 * @author 周昱君
	 *
	 */
	private  final class RestoreWindowListener extends SelectionAdapter{
		@Override
		public void widgetSelected(SelectionEvent e) {
			restoreWindow();
		}
	}
	/**
	 * 菜单
	 */
	private Menu menu;
	/**
	 * 菜单项
	 */
	private MenuItem[] menuItems = new MenuItem[0];
	
	/**
	 * 恢复监听器
	 */
	private RestoreWindowListener restoreWindowListener;
	
	
	public SystemTrayMaster() {
		super();
		restoreWindowListener = new RestoreWindowListener();
	}
	
	/**
	 * 关闭应用
	 */
	public void closeApplication() {
		PlatformUI.getWorkbench().close();
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * get system shell
	 * @return
	 */
	private Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
	/**
	 * 最小化
	 */
	public void minimizeWindow() {
		getShell().setMinimized(true);
		getShell().setVisible(false);
	}
	
	/**
	 * 恢复窗口
	 */
	protected void restoreWindow() {
		Shell shell = getShell();
		shell.open();
		shell.forceActive();
		shell.forceFocus();
	}
	
	
	public void showMenu() {
		clearItems();
		
		MenuItem closeItem = new MenuItem(menu, SWT.NONE);
	    closeItem.setText("退出系统[&E]");
		closeItem.setToolTipText("退出系统");
		closeItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				closeApplication();
			}
		});
		MenuItem openItem = new MenuItem(menu, SWT.PUSH);
		openItem.setText("还原[&O]" );  
		openItem.setToolTipText("还原界面");
		openItem.addSelectionListener(this.restoreWindowListener);   
		this.menuItems =  new  MenuItem[] { openItem, closeItem}; 
	    this.menu.setVisible( true );  
	}
	
	
	
	/**
	 * 清理托盘菜单项
	 */
	private void clearItems() {
		for (int i = 0; i < menuItems.length; i++) {
			MenuItem item = menuItems[i];
			item.removeSelectionListener(this.restoreWindowListener);  
		    menuItems[i].dispose();   
		}
	}
	
	
	@Override
	public void handleEvent(Event event) {
		showMenu();
	}

	/**
	 * 创建系统托盘项
	 */
	public void createSystemTray() {
		//获取系统托盘
		Tray tray = Display.getDefault().getSystemTray();
		//创建托盘项目
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		//指定名称和提示问题
		trayItem.setText("经费测算");
		trayItem.setToolTipText("经费测算");
		//创建托盘图标
		Image image =  AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.VIEW_SYSTEM_TRAY_ITEM_ICO)
				.createImage();
		trayItem.setImage(image);
		//增加单击监听处理
		trayItem.addSelectionListener(this );  
		//增加右键监听处理：弹出菜单
		trayItem.addListener(SWT.MenuDetect, this );   
		
		menu = new  Menu(getShell(), SWT.POP_UP);  
	}
}
