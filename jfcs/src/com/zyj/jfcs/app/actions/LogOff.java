package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * ע��Action
 * @author ���ž�
 *
 */
public class LogOff extends Action{

	public LogOff() {
		super();
		setId(AppConst.ACTION_LOG_OFF);
		setText("�û�ע��[&R]");
		setToolTipText("�û�ע��");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_LOG_OFF));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

}
