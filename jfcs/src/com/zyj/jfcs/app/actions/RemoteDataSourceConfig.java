package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 系统管理菜单：远程 数据源配置
 */
public class RemoteDataSourceConfig extends Action{

	public RemoteDataSourceConfig() {
		super();
		setId("dataBak");
		setText("数据备份@Alt+D");	//指定快捷键
		setToolTipText("数据备份");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

	@Override
	public void run() {
		super.run();
	}

}
