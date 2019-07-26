package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 公共参数设置
 * @author 周昱君
 *
 */
public class PublicData extends Action{

	public PublicData() {
		super();
		setId(AppConst.ACTION_HISTORY_DATA);
		setText("公共参数@Alt+P");	
		setToolTipText("公共参数设置");
		setImageDescriptor(
				AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

}
