package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 测算数据菜单：图形对比
 * @author 周昱君
 *
 */
public class GraphicsData extends Action{

	public GraphicsData() {
		super();
		setId(AppConst.ACTION_GRAPHIC_DATA);
		setText("图形对比@Alt+Z");	
		setToolTipText("图形对比");
		setImageDescriptor(
				AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

}
