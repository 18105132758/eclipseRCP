package com.zyj.jfcs.app.model;
/**
 * 	课程对象
 * @author zhouyj
 *
 */

import java.math.BigDecimal;

public class Course {
	
	private int id;
	/**
	 * 学期
	 */
	private String term;
	/**
	 * 年份
	 */
	private int year;
	/**
	 * 教学单位代码
	 */
	private String unitId;
	/**
	 * 课程代码
	 */
	private String courseId;
	/**
	 * 课程类别
	 */
	private String courseType;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 学生数
	 */
	private int nj;
	/**
	 *  学时数
	 */
	private int n2j;
	/**
	 * 学生层次系数， 考虑到精度问题，使用BigDecimal类型
	 */
	private BigDecimal r1j;
	/**
	 * 课程或专业系数
	 */
	private BigDecimal r2j;
	/**
	 * 课程质量系数
	 */
	private BigDecimal r3j;
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
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getNj() {
		return nj;
	}
	public void setNj(int nj) {
		this.nj = nj;
	}
	public int getN2j() {
		return n2j;
	}
	public void setN2j(int n2j) {
		this.n2j = n2j;
	}
	public BigDecimal getR1j() {
		return r1j;
	}
	public void setR1j(BigDecimal r1j) {
		this.r1j = r1j;
	}
	public BigDecimal getR2j() {
		return r2j;
	}
	public void setR2j(BigDecimal r2j) {
		this.r2j = r2j;
	}
	public BigDecimal getR3j() {
		return r3j;
	}
	public void setR3j(BigDecimal r3j) {
		this.r3j = r3j;
	}
	public TeachUnit getTeachUnit() {
		return teachUnit;
	}
	public void setTeachUnit(TeachUnit teachUnit) {
		this.teachUnit = teachUnit;
	}
	
}
