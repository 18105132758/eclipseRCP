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
	 * �����˵����������桢������Ϣ
	 */
    private IWorkbenchAction welcomeAction, helpInfo;
    
    /**
     * �������ݲ˵����������������á���ѧ��λ���
     */
    private Action publicData, teachUnitData;
    /**
     * �������ݲ˵�: ��ʷ���ݡ�ͼ�ζԱ�
     */
    private Action historyData, graphicsData;
    /**
     * ϵͳ����˵�����ȡ���ݡ��û��������ݱ��ݡ�Զ������Դ���á��������
     */
    private DataBak getServerData, userManage, dataBak, remoteDataSourceConfig, addNewYear;
    
    /**
     * �����˵�: ����ϵͳ
     */
    private Action aboutSystem;
    /**
     * ������: �û�ע������������
     */
    private Action logOff, update;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		welcomeAction = ActionFactory.INTRO.create(window);
		welcomeAction.setText("��ӭʹ��");
		welcomeAction.setAccelerator(SWT.ALT + 87);	//��ݼ� ALT+W
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
