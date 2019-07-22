package com.zyj.jfcs.app.model;
/**
 * 	�γ̶���
 * @author zhouyj
 *
 */

import java.math.BigDecimal;

public class Course {
	
	private int id;
	/**
	 * ѧ��
	 */
	private String term;
	/**
	 * ���
	 */
	private int year;
	/**
	 * ��ѧ��λ����
	 */
	private String unitId;
	/**
	 * �γ̴���
	 */
	private String courseId;
	/**
	 * �γ����
	 */
	private String courseType;
	/**
	 * �γ�����
	 */
	private String courseName;
	/**
	 * �༶����
	 */
	private String className;
	/**
	 * ѧ����
	 */
	private int nj;
	/**
	 *  ѧʱ��
	 */
	private int n2j;
	/**
	 * ѧ�����ϵ���� ���ǵ��������⣬ʹ��BigDecimal����
	 */
	private BigDecimal r1j;
	/**
	 * �γ̻�רҵϵ��
	 */
	private BigDecimal r2j;
	/**
	 * �γ�����ϵ��
	 */
	private BigDecimal r3j;
	/**
	 * ������ѧ��λ
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
