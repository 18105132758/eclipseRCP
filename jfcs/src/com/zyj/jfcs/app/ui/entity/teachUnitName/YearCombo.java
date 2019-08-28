package com.zyj.jfcs.app.ui.entity.teachUnitName;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
/**
 * 年度参数组合框
 * @author zhouyj
 *
 */
public class YearCombo extends ControlContribution {
	
	public static final YearCombo INSTANCE = new YearCombo("com.zyj.jfcs.app.ui.entity.teachUnitName.YearCombo");
	
	private Combo combo;
	
	
	protected YearCombo(String id) {
		super(id);
	}

	@Override
	protected Control createControl(Composite parent) {
		combo = new Combo(parent, SWT.READ_ONLY);
		for(int i = YearManager.INSTANCE.getMinYear(); i <= YearManager.INSTANCE.getMaxYear(); i++) {
			combo.add(i + "");
		}
		combo.select(0);
		YearManager.INSTANCE.setCurrYear(Integer.parseInt(combo.getText()));
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("选中：" + e.text);
				System.out.println(combo.getText());
				int currYear = Integer.parseInt(combo.getText());
				if(currYear == YearManager.INSTANCE.getCurrYear()) {
					//选的同一个值，没有变化
					return;
				}
				YearManager.INSTANCE.setCurrYear(currYear);
				//激活属性变化事件
				CurrYearPropertyChange.INSTANCE.firePropertyChangeListeners();
			}
		});
		
		return combo;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

}
