package com.zyj.jfcs.app.ui.login;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
/**
 * 系统登陆界面
 * @author zhouyj
 *
 */
public class LoginDialog extends Dialog {

	protected Object result;
	protected Shell shell;

	private Text userName;
	private Text password;
	private Button button;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LoginDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText("经费测算系统");
		shell.setLayout(new GridLayout(5, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		CLabel userNameLabel = new CLabel(shell, SWT.NONE);
		userNameLabel.setAlignment(SWT.RIGHT);
		userNameLabel.setText("用户名：");
		new Label(shell, SWT.NONE);
		
		userName = new Text(shell, SWT.BORDER);
		userName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		CLabel passwordLabel = new CLabel(shell, SWT.NONE);
		passwordLabel.setAlignment(SWT.RIGHT);
		passwordLabel.setText("密    码：");
		new Label(shell, SWT.NONE);
		
		password = new Text(shell, SWT.BORDER);
		password.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		button = new Button(shell, SWT.NONE);
		button.setText("登陆");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

	}
	
	
	protected Control createDialogArea(Composite parent) {
		shell = new Shell(getParent(), getStyle());
		Composite container = new Composite(shell, SWT.NONE);
		container.setSize(450, 300);
//		container.setText("经费测算系统");
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		
		CLabel userNameLabel = new CLabel(shell, SWT.NONE);
		userNameLabel.setText("用户名:");
//		userNameLabel.setImage(CacheImage.getImage(, imagePath));
		
		userName = new Text(shell, SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		CLabel passwordLabel = new CLabel(shell, SWT.NONE);
		passwordLabel.setText("密    码:");
//		passwordLabel.setImage();
		
		password = new Text(shell, SWT.BORDER);
		password.setEchoChar('*');
		password.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		return container;
	}
	
	Button loginBtn;
	Button logOffBtn;
	protected void createButtons(Composite parent) {
		loginBtn = new Button(parent, SWT.NONE);
		loginBtn.setText("登陆");
		loginBtn.forceFocus();
		
		logOffBtn = new Button(parent, SWT.NONE);
		logOffBtn.setText("退出");
	}
}
