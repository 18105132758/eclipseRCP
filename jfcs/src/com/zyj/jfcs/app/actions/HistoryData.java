package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 *  测算数据菜单：历史数据
 * @author 周昱君
 *
 */
public class HistoryData extends Action{

	public HistoryData() {
		super();
		setId(AppConst.ACTION_HISTORY_DATA);
		setText("历史数据@Alt+H");	
		setToolTipText("历史数据");
		setImageDescriptor(
				AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

}
