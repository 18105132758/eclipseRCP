package com.zyj.jfcs.app.model;
/**
 * 经费对象， 对应经费测算结果，避免每次查询经费测算结果都实时计算得到。
 * @author zhouyj
 */
public class Calcresult {
	
	private int id;
	
	private int year;
	/**
	 * 教学单位ID
	 */
	private String unitId;
	/**
	 * 学生经费
	 */
	private double ui;
	/**
	 * 专业培养费
	 */
	private double pi;
	/**
	 * 公共课经费
	 */
	private double ci;
	/**
	 * 人员经费
	 */
	private double ryjf;
	/**
	 * 综合业务费
	 */
	private double zhywf;
	/**
	 * 所属教学单位
	 */
	private TeachUnit teachUnit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public double getUi() {
		return ui;
	}
	public void setUi(double ui) {
		this.ui = ui;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public double getCi() {
		return ci;
	}
	public void setCi(double ci) {
		this.ci = ci;
	}
	public double getRyjf() {
		return ryjf;
	}
	public void setRyjf(double ryjf) {
		this.ryjf = ryjf;
	}
	public double getZhywf() {
		return zhywf;
	}
	public void setZhywf(double zhywf) {
		this.zhywf = zhywf;
	}
	public TeachUnit getTeachUnit() {
		return teachUnit;
	}
	public void setTeachUnit(TeachUnit teachUnit) {
		this.teachUnit = teachUnit;
	}
	
}
