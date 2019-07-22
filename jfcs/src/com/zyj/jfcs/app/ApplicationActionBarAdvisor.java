package com.zyj.jfcs.app;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.zyj.jfcs.app.actions.DataBak;

import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	/**
	 * 帮助菜单：欢饮画面、帮助信息
	 */
    private IWorkbenchAction welcomeAction, helpInfo;
    
    /**
     * 基础数据菜单：公共参数适设置、教学单位情况
     */
    private Action publicData, teachUnitData;
    /**
     * 测试数据菜单: 历史数据、图形对比
     */
    private Action historyData, graphicsData;
    /**
     * 系统管理菜单：获取数据、用户管理、数据备份、远程数据源配置、新增年度
     */
    private DataBak getServerData, userManage, dataBak, remoteDataSourceConfig, addNewYear;
    
    /**
     * 帮助菜单: 关于系统
     */
    private Action aboutSystem;
    /**
     * 工具栏: 用户注销、在线升级
     */
    private Action logOff, update;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		welcomeAction = ActionFactory.INTRO.create(window);
		welcomeAction.setText("欢迎使用");
		welcomeAction.setAccelerator(SWT.ALT + 87);	//快捷键 ALT+W
		register(welcomeAction);
		
		dataBak = new DataBak();
		register(dataBak);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		
		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);
		helpMenu.add(welcomeAction);

		menuBar.add(dataBak);
	}

}
