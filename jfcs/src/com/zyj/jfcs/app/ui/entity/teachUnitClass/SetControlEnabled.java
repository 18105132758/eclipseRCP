package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import com.zyj.jfcs.app.model.SaveLogInfo;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;

public class SetControlEnabled {
	public boolean isEnabled(int curYear) {
		//1: 财务处、 2：学校领导
		return "12".contains(SaveLogInfo.getINSTANCE().getUsertag()) && curYear == YearManager.INSTANCE.getMaxYear();
	}
}
