package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 教学单位情况
 * @author 周昱君
 *
 */
public class TeachUnitData extends Action{
	public TeachUnitData() {
		super();
		setId(AppConst.ACTION_TEACH_UNIT_DATA);
		setText("教学单位@Alt+D");	//指定快捷键
		setToolTipText("教学单位情况");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}
}
