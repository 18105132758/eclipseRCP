package com.zyj.jfcs.app.sys;

import java.util.Timer;
import java.util.TimerTask;

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
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;
/**
 * 系统托盘相关类，负责初始化系统托盘及相关功能
 * @author 周昱君
 *
 */
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
	/**
	 * 托盘项目
	 */
	private TrayItem trayItem;
	
	/**
	 * 托盘图标
	 */
	private Image trayImage = null;
	
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
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
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
		menuItems = new MenuItem[0];
	}
	
	
	@Override
	public void handleEvent(Event event) {
		showMenu();
	}
	
	/**
	 * 销毁托盘相关资源
	 */
	public void dispose() {
		clearItems();
		if(trayItem != null) {
			trayItem.dispose();
		}
		if(trayImage != null) {
			trayImage.dispose();
		}
	}
	

	/**
	 * 创建系统托盘项
	 */
	public void createSystemTray(IWorkbenchWindow window) {
		//获取系统托盘
		Tray tray = Display.getDefault().getSystemTray();
		//创建托盘项目
		trayItem = new TrayItem(tray, SWT.NONE);
		//指定名称和提示问题
		trayItem.setText("经费测算");
		trayItem.setToolTipText("经费测算");
		//创建托盘图标
		trayImage =  CacheImage.getImage(AppConst.APPLICATION_ID, ImagePath.VIEW_SYSTEM_TRAY_ITEM_ICO);
		trayItem.setImage(trayImage);
		//增加单击监听处理
		trayItem.addSelectionListener(this );  
		//增加右键监听处理：弹出菜单
		trayItem.addListener(SWT.MenuDetect, this );   
		//创建菜单
		menu = new  Menu(getShell(), SWT.POP_UP);  
		
		
		//增加气泡提示文字: 每10秒提示一次
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Display display = window.getShell().getDisplay();
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						System.out.println("气泡文字。。。。。。。。。。");
						ToolTip tip = new ToolTip(window.getShell(), 
								SWT.BALLOON | SWT.ICON_INFORMATION);
//						tip.setAutoHide(true);	//自动隐藏气泡提示文字
						tip.setMessage(AppConst.APPLICATION_TITLE);
						tip.setText("欢迎使用");
						trayItem.setToolTip(tip);
						tip.setVisible(true);
					}
				});
			}
		}, 0, 20 * 1000);
	}
}
