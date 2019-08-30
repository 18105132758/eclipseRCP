package com.zyj.jfcs.app.model;
/**
 * 教学单位年度经费数据
 * @author zhouyj
 *
 */
public class YearUnitJF {
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
	 * 总经费
	 */
	public double getTotal() {
		return ui + pi + ci + ryjf + zhywf;
	}

	/**
	 * 	获取经费比例
	 * @param jf
	 * @return
	 */
	public double getPer(double jf) {
		return jf / getTotal();
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
	
}
