package com.zyj.jfcs.app.model;
/**
 * 教学单位年度基本数据对象，描述各个教学单位在各个年度的基本数据，因为不同年度各个教学单位的基本数据可能不同
 * @author zhouyj
 *
 */

import java.math.BigDecimal;

public class YearTeachUnit {

	private int id;
	
	private int year;
	
	private String unitId;
	/**
	 * 是否有专业课
	 */
	private String haszyk;
	/**
	 * 是否有公共课
	 */
	private String hasggk;
	/**
	 * 师生比
	 */
	private int ssb;
	/**
	 * 学费应收金额
	 */
	private BigDecimal jfys;
	/**
	 * 学费实收金额
	 */
	private BigDecimal jfss;
	/**
	 * 教学业务费比例
	 */
	private BigDecimal jxywper;
	/**
	 * 教学管理费比例
	 */
	private BigDecimal jxglper;
	/**
	 * 教学研究费比例
	 */
	private BigDecimal jxyjper;
	/**
	 * 师资培养费比例
	 */
	private BigDecimal sjpyper;
	/**
	 * 教授A等人数
	 */
	private BigDecimal ta1;
	/**
	 * 教授B等人数
	 */
	private BigDecimal ta2;
	/**
	 * 教授C等人数
	 */
	private BigDecimal ta3;
	/**
	 * 教授D等人数
	 */
	private BigDecimal ta4;
	/**
	 * 副教授A等人数
	 */
	private BigDecimal ta5;
	/**
	 * 副教授B等人数
	 */
	private BigDecimal ta6;
	/**
	 * 讲师人数
	 */
	private BigDecimal ta7;
	/**
	 * 助教人数
	 */
	private BigDecimal ta8;
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
	public String getHaszyk() {
		return haszyk;
	}
	public void setHaszyk(String haszyk) {
		this.haszyk = haszyk;
	}
	public String getHasggk() {
		return hasggk;
	}
	public void setHasggk(String hasggk) {
		this.hasggk = hasggk;
	}
	public int getSsb() {
		return ssb;
	}
	public void setSsb(int ssb) {
		this.ssb = ssb;
	}
	public BigDecimal getJfys() {
		return jfys;
	}
	public void setJfys(BigDecimal jfys) {
		this.jfys = jfys;
	}
	public BigDecimal getJfss() {
		return jfss;
	}
	public void setJfss(BigDecimal jfss) {
		this.jfss = jfss;
	}
	public BigDecimal getJxywper() {
		return jxywper;
	}
	public void setJxywper(BigDecimal jxywper) {
		this.jxywper = jxywper;
	}
	public BigDecimal getJxglper() {
		return jxglper;
	}
	public void setJxglper(BigDecimal jxglper) {
		this.jxglper = jxglper;
	}
	public BigDecimal getJxyjper() {
		return jxyjper;
	}
	public void setJxyjper(BigDecimal jxyjper) {
		this.jxyjper = jxyjper;
	}
	public BigDecimal getSjpyper() {
		return sjpyper;
	}
	public void setSjpyper(BigDecimal sjpyper) {
		this.sjpyper = sjpyper;
	}
	public BigDecimal getTa1() {
		return ta1;
	}
	public void setTa1(BigDecimal ta1) {
		this.ta1 = ta1;
	}
	public BigDecimal getTa2() {
		return ta2;
	}
	public void setTa2(BigDecimal ta2) {
		this.ta2 = ta2;
	}
	public BigDecimal getTa3() {
		return ta3;
	}
	public void setTa3(BigDecimal ta3) {
		this.ta3 = ta3;
	}
	public BigDecimal getTa4() {
		return ta4;
	}
	public void setTa4(BigDecimal ta4) {
		this.ta4 = ta4;
	}
	public BigDecimal getTa5() {
		return ta5;
	}
	public void setTa5(BigDecimal ta5) {
		this.ta5 = ta5;
	}
	public BigDecimal getTa6() {
		return ta6;
	}
	public void setTa6(BigDecimal ta6) {
		this.ta6 = ta6;
	}
	public BigDecimal getTa7() {
		return ta7;
	}
	public void setTa7(BigDecimal ta7) {
		this.ta7 = ta7;
	}
	public BigDecimal getTa8() {
		return ta8;
	}
	public void setTa8(BigDecimal ta8) {
		this.ta8 = ta8;
	}
	public TeachUnit getTeachUnit() {
		return teachUnit;
	}
	public void setTeachUnit(TeachUnit teachUnit) {
		this.teachUnit = teachUnit;
	}
	
	
}
