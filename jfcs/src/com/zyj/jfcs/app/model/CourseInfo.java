package com.zyj.jfcs.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 课程信息对象，每个学期都有单独的课程对象
 * @author zhouyj
 *
 */
@Entity
@Table(name = "COURSE_INFO")
public class CourseInfo {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private int id;
	/**
	 * 学期
	 */
	@Column(name = "TERM", length = 50)
	private String term;
	
	@Column(name = "YEAR")
	private int year;
	
	/**
	 * 教学单位ID
	 */
	
	@Column(name = "UNIT_ID", length = 50)
	private String unitId;
	/**
	 * 课程代码
	 */
	@Column(name = "COURSE_ID", length = 50)
	private String courseId;
	/**
	 * 课程名称
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;
	/**
	 * 课程类别
	 */
	@Column(name = "COURSE_TYPE", length = 50)
	private String courseType;
	
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
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
	
}
