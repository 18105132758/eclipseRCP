package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import java.util.ArrayList;
import java.util.List;

public class CourseTreeParent {
	private String courseName;
	
	private List<CourseTreeChildren> courseTreeChildren;

	public CourseTreeParent(String courseName) {
		super();
		this.courseName = courseName;
		this.courseTreeChildren = new ArrayList<CourseTreeChildren>();
	}

	/**
	 * 添加子节点
	 * @param course
	 */
	public void add(CourseTreeChildren course) {
		if(!this.courseTreeChildren.contains(course)) {
			this.courseTreeChildren.add(course);
			course.setCourseParent(this);
		}
	}

	public List<CourseTreeChildren> getCourseTreeChildren() {
		return courseTreeChildren;
	}

	public void setCourseTreeChildren(List<CourseTreeChildren> courseTreeChildren) {
		this.courseTreeChildren = courseTreeChildren;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
