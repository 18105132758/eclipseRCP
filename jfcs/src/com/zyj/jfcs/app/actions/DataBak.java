package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 系统管理菜单：数据备份action
 */
public class DataBak extends Action{

	public DataBak() {
		super();
		setId(AppConst.ACTION_DATA_BACK);
		//设置显示文本， 并指定快捷键
		setText("数据备份@Alt+D");	
		//设置悬停提示文本
		setToolTipText("数据备份");
		//设置图标
		setImageDescriptor(
				//AbstractUIPlugin.imageDescriptorFromPlugin(AppId，图片Path)可以快速获取图像，
				AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
		
	}

	
	@Override
	public void run() {
		super.run();
	}

}
