package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 系统管理菜单：获取数据
 * @author 周昱君
 *
 */
public class GetServerData extends Action{

	public GetServerData() {
		super();
		setId(AppConst.ACTION_GET_SERVER_DATA);
		setText("获取数据@Alt+G");	
		setToolTipText("获取数据");
		setImageDescriptor(
				AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

}
