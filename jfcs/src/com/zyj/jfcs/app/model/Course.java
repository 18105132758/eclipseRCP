package com.zyj.jfcs.app.model;
/**
 * 	课程对象
 * @author zhouyj
 *
 */

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "JFCS_COURSE")
public class Course {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private int id;
	
	/**
	 * 学期
	 */
	@Column(name = "TERM", length = 100)
	private String term;
	/**
	 * 年份
	 */
	@Column(name = "YEAR")
	private int year;
	/**
	 * 教学单位代码
	 */
	@Column(name = "UNIT_ID", length = 50)
	private String unitId;
	/**
	 * 课程代码
	 */
	@Column(name = "COURSE_ID", length = 20)
	private String courseId;
	/**
	 * 课程类别
	 */
	@Column(name = "COURSE_TYPE", length = 20)
	private String courseType;
	/**
	 * 课程名称
	 */
	@Column(name = "COURSE_NAME", length = 200)
	private String courseName;
	/**
	 * 班级名称
	 */
	@Column(name = "CLASS_NAME", length = 200)
	private String className;
	/**
	 * 学生数
	 */
	@Column(name = "NJ")
	private int nj;
	/**
	 *  学时数
	 */
	
	@Column(name = "N2J")
	private int n2j;
	/**
	 * 学生层次系数， 考虑到精度问题，使用BigDecimal类型
	 */
	@Column(name = "R1J")
	private BigDecimal r1j;
	/**
	 * 课程或专业系数
	 */
	@Column(name = "R2J")
	private BigDecimal r2j;
	/**
	 * 课程质量系数
	 */
	@Column(name = "R3J")
	private BigDecimal r3j;
	/**
	 * 所属教学单位
	 */
//	@Column(name = "TEACH_UNIT")
	@Transient
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
