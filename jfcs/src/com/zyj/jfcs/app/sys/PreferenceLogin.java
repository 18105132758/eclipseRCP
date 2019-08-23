package com.zyj.jfcs.app.sys;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.runtime.AuthorizationHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.prefs.BackingStoreException;

import com.zyj.jfcs.app.ui.login.LoginDialog;
import com.zyj.jfcs.app.ui.login.UserTemp;
import com.zyj.jfcs.constants.AppConst;

/**
 * 通过preference登陆验证
 * @author zhouyj
 *
 */
public class PreferenceLogin {
	
	public boolean isLogin() {
		
		LoginDialog loginDialog = new LoginDialog(Display.getCurrent().getActiveShell());
		boolean isLogined = false;
		
		while(!isLogined) {
			if(loginDialog.open() != Window.OK) {
				//取消登陆，结束
				return false;
			}
			//执行登陆，获取用户名、密码信息
			String userName = UserTemp.userName;
			String password = UserTemp.password;
			//验证用户名、密码
			isLogined = isValidate(userName, password);
			
			if(!isLogined) {
				MessageDialog.openWarning(null, "提示", "用户名或密码错误,无法登陆");
			}
		}
		return isLogined;
	}
	
	public boolean isValidate(String userName, String password) {
		Map authorization = AuthorizationHandler.getAuthorizationInfo(Platform.getInstanceLocation().getURL(), "", "Digest");
		if(authorization == null) {
			//首次登陆
			Map<String, String> logUser = new HashMap<String, String>();
			logUser.put("userName", userName);
			logUser.put("password", password);
			try {
				AuthorizationHandler.addAuthorizationInfo(Platform.getInstanceLocation().getURL(), "", "Digest", logUser);
				return true;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		String prefName = authorization.get("userName").toString().trim();
		String prefPwd = authorization.get("password").toString().trim();
		
		if(userName.equals(prefName) && password.equals(prefPwd)) {
			//登陆成功
			return true;
		}
		return false;
	}
	
	/**
	 * 验证账号密码是否正确
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean isValidate2(String userName, String password) {
		IEclipsePreferences preferences = ConfigurationScope.INSTANCE.getNode(AppConst.APPLICATION_ID);
		//获取preferences中缓存的账号信息
		String preName = preferences.get("userName", null);
		String prePwd = preferences.get("password", null);
		
		if(preName == null || prePwd == null) {
			//首次登陆，缓存账号信息，登陆成功
			preferences.put("userName", userName);
			preferences.put("password", password);
			try {
				preferences.flush();
				return true;
			} catch (BackingStoreException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		if(userName.equals(preName) && password.equals(prePwd)) {
			//登陆成功
			return true;
		}
		return false;
	}
}
