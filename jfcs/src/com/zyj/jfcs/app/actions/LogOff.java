package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 注销Action
 * @author 周昱君
 *
 */
public class LogOff extends Action{

	public LogOff() {
		super();
		setId(AppConst.ACTION_LOG_OFF);
		setText("用户注销[&R]");
		setToolTipText("用户注销");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_LOG_OFF));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

}
