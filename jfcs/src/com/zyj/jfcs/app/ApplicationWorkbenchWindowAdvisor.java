package com.zyj.jfcs.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.zyj.jfcs.app.sys.HookSysTray;
import com.zyj.jfcs.constants.AppConst;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * 系统托盘
	 */
	private HookSysTray hookSysTray;
	
    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    /**
     * 	该方法在窗口打开之前调用，可以用来设置窗口的构成元素，大小；
     * 	如果需要在窗口打开之后进行一些操作，则需要在postWindowOpen()中进行
     */
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        //设置初始大小： 700 * 550
        configurer.setInitialSize(new Point(700, 550));
        //显示 工具栏
        configurer.setShowCoolBar(true);
        //显示状态栏
        configurer.setShowStatusLine(true);
        //窗口只显示：最小化、关闭按钮
        configurer.setShellStyle(SWT.MIN | SWT.CLOSE);
        configurer.setTitle(AppConst.APPLICATION_TITLE);
    }

    /**
     * 	此方法可以执行必须在窗口打开之后才能进行的操作，如调整窗口的位置
     */
	@Override
	public void postWindowOpen() {
		super.postWindowOpen();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Rectangle screeSize = Display.getDefault().getClientArea();	//屏幕尺寸
		Rectangle frameSize = shell.getBounds();	//窗口尺寸
		//设置窗口居中， setLocation方法设置窗口左上角的坐标， 屏幕坐标系是以屏幕左上角为原点，向右(OX)、向下(OY)为正
		shell.setLocation((screeSize.width - frameSize.width) / 2, (screeSize.height - frameSize.height) / 2);
		
		//创建系统托盘
		createSystemTray();
	}
    

	
	@Override
	public boolean preWindowShellClose() {
		hookSysTray.windowMinimized(getWindowConfigurer().getWindow().getShell());
		return false;	//不关闭窗口
	}

	/**
	 * 创建托盘
	 */
	private void createSystemTray() {
		hookSysTray = new HookSysTray();
		hookSysTray.createSysTray(getWindowConfigurer().getWindow());
	}

	@Override
	public void dispose() {
		hookSysTray.dispose();
	}
	
}
