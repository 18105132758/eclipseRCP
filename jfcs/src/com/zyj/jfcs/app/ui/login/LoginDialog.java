package com.zyj.jfcs.app.ui.login;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.zyj.jfcs.app.service.user.UserLoginService;
import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.app.ui.utils.MessageUtils;
import com.zyj.jfcs.constants.ImagePath;
/**
 * 系统登陆界面
 * @author zhouyj
 *
 */
public class LoginDialog extends Dialog {

	private Text userName;
	private Text password;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		//创建容器、设置布局
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.marginRight = 6;
		container.setLayout(layout);
		
		//创建用户名：标签、输入框
		CLabel userNameLabel = new CLabel(container, SWT.NONE);
		userNameLabel.setText("用户名:");
		userNameLabel.setImage(CacheImage.getAppImage(ImagePath.LOGIN_USERNAME_ICO));
		
		userName = new Text(container, SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		//创建密码：标签、输入框
		CLabel passwordLabel = new CLabel(container, SWT.NONE);
		passwordLabel.setText("密    码:");
		passwordLabel.setImage(CacheImage.getAppImage(ImagePath.LOGIN_PASSWORD_ICO));
		
		password = new Text(container, SWT.BORDER);
		password.setEchoChar('*');	//密码使用*号作为明文
		password.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		return container;
	}
	

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		/**
		 * Dialog预定义了一些按钮，可以通过IDialogConstants中定义的类型来指定
		 */
		//创建登录按钮
		createButton(parent, IDialogConstants.OK_ID, "登陆", true);
		//创建退出按钮
		createButton(parent, IDialogConstants.CANCEL_ID, "退出", true);
	}


	@Override
	protected Point getInitialSize() {
		//指定窗口的初始大小
		return new Point(400, 250);
	}


	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		//设置窗口标题
		newShell.setText("用户身份验证");
		//设置标题图标
		newShell.setImage(CacheImage.getAppImage(ImagePath.LOGIN_TITLE_ICO));
	}


	@Override
	protected void okPressed() {
		//获取用户名、密码
		String userName = this.userName.getText();
		String password = this.password.getText();
		if(StringUtils.isBlank(userName)) {
			//用户名为空, 提示用户
			MessageUtils.smallErrorMsgDialog(getShell(), "提示", "用户名不能为空！");
			this.userName.setFocus();
			return;
		}
		if(StringUtils.isBlank(password)) {
			//密码为空
			MessageUtils.smallErrorMsgDialog(getShell(), "提示", "密码不能为空！");
			this.password.setFocus();
			return;
		}
		
		UserLoginService loginService = new UserLoginService();
		boolean loginSuccess = loginService.doLogin(userName, password);
		if(loginSuccess) {
			super.okPressed();
		}
	}

}
