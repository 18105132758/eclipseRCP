package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;
/**
 * 关于系统action
 * @author 周昱君
 *
 */
public class AboutSystem extends Action{

	public AboutSystem() {
		super();
		setId(AppConst.ACTION_ABOUT_SYSTEM);
		setText("关于经费测算系统@ALT+A");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_ABOUT_SYSTEM));
	}

	@Override
	public void run() {
		super.run();
	}
	
}
