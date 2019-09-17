package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jface.viewers.ITreeContentProvider;
/**
 * 课程明细 TreeViewer内容提供器
 */
public class TeachUnitClassContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return ((List<?>)inputElement).toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof CourseTreeParent) {
			return ((CourseTreeParent)parentElement).getCourseTreeChildren().toArray();
		}
		return ArrayUtils.EMPTY_OBJECT_ARRAY;
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof CourseTreeChildren) {
			return ((CourseTreeChildren)element).getCourseParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
