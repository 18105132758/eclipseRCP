package com.zyj.jfcs.app.model;

/**
 * 教学单位基类，定义教学单位公共属性
 * @author 周昱君
 *
 */
public class AbstractTeachUnit implements ITeachUnit{

	private String unitId;
	
	private String unitName;
	
	@Override
	public String getUnitId() {
		return unitId;
	}

	@Override
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Override
	public String getUnitName() {
		return unitName;
	}

	@Override
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
