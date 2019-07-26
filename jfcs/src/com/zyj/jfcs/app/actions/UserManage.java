package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 系统用户管理
 * @author 周昱君
 *
 */
public class UserManage extends Action{
	public UserManage() {
		super();
		setId(AppConst.ACTION_USER_MANAGE);
		setText("用户管理@Alt+M");	//指定快捷键
		setToolTipText("用户管理");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}
}
