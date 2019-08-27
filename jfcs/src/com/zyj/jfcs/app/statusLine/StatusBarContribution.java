package com.zyj.jfcs.app.statusLine;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.StatusLineLayoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.constants.ImagePath;

public class StatusBarContribution extends ContributionItem{
	private String message;

	@Override
	public void fill(Composite parent) {
		//添加分隔线
		Label separator = new Label(parent, SWT.SEPARATOR);
		//布局数据
		StatusLineLayoutData layoutData = new StatusLineLayoutData();
		layoutData.heightHint = 20;
		separator.setLayoutData(layoutData);
		//显示文字信息标签
		CLabel statusCLabel = new CLabel(parent, SWT.SHADOW_NONE);
		layoutData = new StatusLineLayoutData();
		layoutData.widthHint = 135;
		statusCLabel.setLayoutData(layoutData);
		statusCLabel.setText(message);
		statusCLabel.setImage(CacheImage.getAppImage(ImagePath.STATUS_LINE__TITLE_ICO));
	}

	public StatusBarContribution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusBarContribution(String msg) {
		this.message = msg;
	}
	
	
}
