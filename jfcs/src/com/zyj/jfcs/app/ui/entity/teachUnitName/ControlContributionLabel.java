package com.zyj.jfcs.app.ui.entity.teachUnitName;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
/**
 * 工具栏使用的标签类
 * @author zhouyj
 *
 */
public class ControlContributionLabel extends ControlContribution{

	private String text;
	
	protected ControlContributionLabel(String id) {
		super(id);
	}
	
	public ControlContributionLabel(String id, String text) {
		super(id);
		this.text = text;
	}



	@Override
	protected Control createControl(Composite parent) {
		CLabel label = new CLabel(parent, SWT.NONE);
		label.setText(text);
		return label;
	}

}
