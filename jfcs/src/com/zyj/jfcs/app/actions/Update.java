package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 工具栏：在线升级
 * @author 周昱君
 *
 */
public class Update extends Action{
	public Update() {
		super();
		setId(AppConst.ACTION_ONLINE_UPDATE);
		setText("在线升级@Alt+U");	//指定快捷键
		setToolTipText("在线升级");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}
}
