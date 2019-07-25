package com.zyj.jfcs.app;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.zyj.jfcs.app.actions.AboutSystem;
import com.zyj.jfcs.app.actions.AddNewYear;
import com.zyj.jfcs.app.actions.DataBak;
import com.zyj.jfcs.app.actions.GetServerData;
import com.zyj.jfcs.app.actions.GraphicsData;
import com.zyj.jfcs.app.actions.HistoryData;
import com.zyj.jfcs.app.actions.LogOff;
import com.zyj.jfcs.app.actions.PublicData;
import com.zyj.jfcs.app.actions.RemoteDataSourceConfig;
import com.zyj.jfcs.app.actions.TeachUnitData;
import com.zyj.jfcs.app.actions.Update;
import com.zyj.jfcs.app.actions.UserManage;

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
    private Action getServerData, userManage, dataBak, remoteDataSourceConfig, addNewYear;
    
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
		
		//系统帮助
		helpInfo = ActionFactory.HELP_CONTENTS.create(window);
		helpInfo.setText("系统帮助@ALT+H");
		helpInfo.setToolTipText("系统帮助");
		register(helpInfo);
		
		//公共参数
		publicData = new PublicData();
		register(publicData);
		
		//教学单位数据
		teachUnitData = new TeachUnitData();
		register(teachUnitData);
		
		//历史数据
		historyData = new HistoryData();
		register(historyData);
		
		//图形对比
		graphicsData = new GraphicsData();
		register(graphicsData);
		
		//获取服务器数据
		getServerData = new GetServerData();
		register(getServerData);
		
		userManage = new UserManage();
		register(userManage);
		
		dataBak = new DataBak();
		register(dataBak);
		
		remoteDataSourceConfig = new RemoteDataSourceConfig();
		register(remoteDataSourceConfig);
		
		addNewYear = new AddNewYear();
		register(addNewYear);

		aboutSystem = new AboutSystem();
		register(aboutSystem);
		
		logOff = new LogOff();
		register(logOff);
		
		update = new Update();
		register(update);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		
		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);
		helpMenu.add(welcomeAction);

		menuBar.add(dataBak);
	}

}
