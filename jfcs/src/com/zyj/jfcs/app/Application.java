package com.zyj.jfcs.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.zyj.jfcs.app.sys.PreferenceLogin;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) {
		Display display = PlatformUI.createDisplay();
		try {
			//关闭闪屏画面
			context.applicationRunning();
//			Platform.endSplash();	//此方法已经过时
			
//			//创建登录界面
//			LoginDialog login = new LoginDialog(null);
//			/*
//			 * 打开登录界面，并等待用户登录，获取登录结果；
//			 * Window.OK表示登录成功
//			 * 这里返回IApplication.EXIT_OK表示登录失败，退出系统，
//			 * 这里可以返回任意内容，都可以结束应用，因此此时还没有创建工作台
//			 */
//			if(login.open() != Window.OK) {
//				return IApplication.EXIT_OK;
//			}
			//创建PreferenceLogin， 并验证登陆
			PreferenceLogin login2 = new PreferenceLogin();
			if(!login2.isLogin()) {
				//登陆失败
				return IApplication.EXIT_OK;
			}
			
			
			//创建工作台
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}

	@Override
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(() -> {
			if (!display.isDisposed())
				workbench.close();
		});
	}
}
