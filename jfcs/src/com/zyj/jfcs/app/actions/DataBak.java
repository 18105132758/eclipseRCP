package com.zyj.jfcs.app.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.ImagePath;

/**
 * ϵͳ����˵������ݱ���action
 */
public class DataBak extends Action{

	public DataBak() {
		super();
		setId("dataBak");
		setText("���ݱ���@Alt+D");	//ָ����ݼ�
		setToolTipText("���ݱ���");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(AppConst.APPLICATION_ID, ImagePath.ACTION_DATA_BACK));
	}

	@Override
	public void run() {
		super.run();
	}

}
