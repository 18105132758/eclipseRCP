package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;
/**
 * ����ϵͳaction
 * @author ���ž�
 *
 */
public class AboutSystem extends Action{

	public AboutSystem() {
		super();
		setId(AppConst.ACTION_ABOUT_SYSTEM);
		setText("���ھ��Ѳ���ϵͳ@ALT+A");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_ABOUT_SYSTEM));
	}

	@Override
	public void run() {
		super.run();
	}
	
}
