package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import com.zyj.jfcs.app.model.Course;

public class CourseTreeChildren {
	
	private CourseTreeParent courseParent;
	
	private Course course;

	public CourseTreeParent getCourseParent() {
		return courseParent;
	}

	public void setCourseParent(CourseTreeParent courseParent) {
		this.courseParent = courseParent;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
