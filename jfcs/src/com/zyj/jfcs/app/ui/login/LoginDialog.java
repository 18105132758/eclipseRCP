package com.zyj.jfcs.app.ui.login;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
/**
 * 系统登陆界面
 * @author zhouyj
 *
 */
public class LoginDialog extends org.eclipse.jface.dialogs.Dialog {

	private Text userName;
	private Text password;

	Button loginBtn;
	Button logOffBtn;
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}


	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.marginRight = 6;
		container.setLayout(layout);
		
		
		CLabel userNameLabel = new CLabel(container, SWT.NONE);
		userNameLabel.setText("用户名:");
//		userNameLabel.setImage(CacheImage.getImage(, imagePath));
		
		userName = new Text(container, SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		CLabel passwordLabel = new CLabel(container, SWT.NONE);
		passwordLabel.setText("密    码:");
//		passwordLabel.setImage();
		
		password = new Text(container, SWT.BORDER);
		password.setEchoChar('*');
		password.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		return container;
	}
	

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "登陆", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "退出", true);
	}


	@Override
	protected Point getInitialSize() {
		return new Point(400, 250);
	}


	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		
		newShell.setText("用户身份验证");
//		newShell.setImage();
	}


	@Override
	protected void okPressed() {
		String userName = this.userName.getText();
		String password = this.password.getText();
		MessageBox mb;
		if(StringUtils.isBlank(userName)) {
			mb = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			mb.setText("提示");
			mb.setMessage("用户名不能为空!");
			mb.open();
			this.userName.setFocus();
			return;
		}
		if(StringUtils.isBlank(password)) {
			mb = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			mb.setText("提示");
			mb.setMessage("密码不能为空!");
			mb.open();
			this.password.setFocus();
			return;
		}
		super.okPressed();
	}
	
	

	
}
