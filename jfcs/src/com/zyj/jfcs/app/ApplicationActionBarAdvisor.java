package com.zyj.jfcs.app;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
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
import com.zyj.jfcs.app.statusLine.StatusBarContribution;
import com.zyj.jfcs.constants.AppConst;

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
    
    
    private StatusBarContribution statusBarContribution;
    
    
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
		
		statusBarContribution = new StatusBarContribution("用户登录！");
		statusBarContribution.setVisible(true);
	}

	
	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
		statusLine.add(statusBarContribution);;
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		/**
		 * 	父级菜单项使用MenuManager？？
		 */
		//创建基础数据一级菜单
		MenuManager baseDataMenu = new MenuManager("基础数据[&B]", AppConst.MENU_BASE_DATA_ID);
		menuBar.add(baseDataMenu);
			//向基础数据填充子菜单项
		baseDataMenu.add(publicData);
		baseDataMenu.add(teachUnitData);
		
		//创建测算数据一级菜单
		MenuManager calcDataMenu = new MenuManager("测算数据[&C]", AppConst.MENU_CALC_DATA_ID);
		menuBar.add(calcDataMenu);
		calcDataMenu.add(historyData);
		calcDataMenu.add(graphicsData);
		
		//创建系统管理一级菜单
		MenuManager sysManageMenu = new MenuManager("系统管理[]&M", AppConst.MENU_SYS_MANAGE_ID);
		menuBar.add(sysManageMenu);
		sysManageMenu.add(getServerData);
		sysManageMenu.add(userManage);
		sysManageMenu.add(dataBak);
		sysManageMenu.add(remoteDataSourceConfig);
		sysManageMenu.add(addNewYear);
		sysManageMenu.add(update);
		
		//创建帮助一级菜单
		MenuManager helpMenu = new MenuManager("帮助&[H]", AppConst.MENU_HELP_ID);
		menuBar.add(helpMenu);
		helpMenu.add(welcomeAction);
		helpMenu.add(helpInfo);
		helpMenu.add(aboutSystem);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		super.fillCoolBar(coolBar);
		/*
		 * 	工具栏的填充在 fillCollBar方法中完成，工具栏的创建需要一个工具栏管理器： ICoolBarManager
		 * 	ICoolBarManager负责工具栏的分类管理，并不管里具体的action，而是将责任委托给具体的子管理器-IToolBarManager
		 * 
		 * 	也可以使用配置扩展点的方式创建工具栏
		 */
		//FLAT: 扁平化工具栏    SHADOW_OUT：在工具栏-菜单栏之间增加一条分隔线
		IToolBarManager toolBar = new ToolBarManager(SWT.FLAT | SWT.SHADOW_OUT);
		coolBar.add(toolBar);
		toolBar.add(publicData);
		toolBar.add(teachUnitData);
		toolBar.add(new Separator());
		toolBar.add(historyData);
		toolBar.add(graphicsData);
		toolBar.add(new Separator());
		toolBar.add(getServerData);
		toolBar.add(dataBak);
		toolBar.add(logOff);
		toolBar.add(new Separator());
		toolBar.add(helpInfo);
	}

	
}
