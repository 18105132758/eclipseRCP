package com.zyj.jfcs.app.service.user;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zyj.jfcs.app.db.factory.HibernateSessionFactory;
import com.zyj.jfcs.app.model.User;
import com.zyj.jfcs.app.ui.utils.MessageUtils;

public class UserLoginService {
	private boolean isSuccess;
	
	/**
	 * 	用户登录
	 * @param userName	用户名
	 * @param password	密码
	 * @return
	 */
	public boolean doLogin(String userName, String password) {
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			MessageDialog.openWarning(null, "提示", "用户名、密码不能为空！");
			MessageUtils.smallErrorMsgDialog(Display.getCurrent().getActiveShell(), "提示", "用户名、密码不能为空！");
			System.out.println("用户名或密码不能为空！");
		}
		//打开登陆进度条
		ProgressMonitorDialog pmd = new ProgressMonitorDialog(null);
		IRunnableWithProgress rwp = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				monitor.beginTask("等在登陆， 请稍后...", IProgressMonitor.UNKNOWN);
				monitor.subTask("验证用户名、密码...");
				TimeUnit.SECONDS.sleep(5);
				isSuccess =  validateOrAddNewUserInfo(userName, password);
				monitor.subTask("验证结束，销毁资源....");
				TimeUnit.SECONDS.sleep(5);
				HibernateSessionFactory.closeSession();
			}
		};
		try {
			pmd.run(true, false, rwp);
			if(!isSuccess) {
				MessageUtils.smallErrorMsgDialog(Display.getCurrent().getActiveShell(), "提示", "用户名、密码不匹配！");
//				MessageDialog.openError(Display.getCurrent().getActiveShell(), "提示", "用户名、密码不匹配！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openWarning(null, "提示", "意外错误：" + e.getMessage());
			isSuccess = false;
		}
		return isSuccess;
	}

	/**
	 * 校验用户信息
	 * @param userName
	 * @param password
	 * @return
	 */
	private boolean validateOrAddNewUserInfo(String userName, String password) {
		User user = queryByUserName(userName);
		if(user == null) {
			//新增
			user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			addUser(user);
			return true;
		}
		
		if(password.equals(user.getPassword())) {
			//成功
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public User queryByUserName(String userName) {
		Session session = HibernateSessionFactory.getSession();
		Query<User> query = session.createQuery("from User where userName=:userName");	
		
		query.setParameter("userName", userName);
		
		User user = query.uniqueResult();
		return user;
	}
	
	
	@SuppressWarnings("unchecked")
	public void addUser(User newUser) {
		Session session = HibernateSessionFactory.getSession();
		
		Query<User> query = session.createQuery("from User where userName=:userName");	
		query.setParameter("userName", newUser.getUserName());
		if(query.getResultList().size() > 0) {
			//用户信息已经存在，方法结束
			return;
		}
		
		Transaction t = session.beginTransaction();
		session.save(newUser);
		t.commit();
		HibernateSessionFactory.closeSession();
	}
}
