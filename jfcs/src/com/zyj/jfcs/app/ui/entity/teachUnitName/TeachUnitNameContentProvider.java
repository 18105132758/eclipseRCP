package com.zyj.jfcs.app.ui.entity.teachUnitName;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * 内容提供器
 * @author zhouyj
 *
 */
public class TeachUnitNameContentProvider implements IStructuredContentProvider{

	@Override
	@SuppressWarnings("rawtypes")
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List) {
			return ((List)inputElement).toArray();
		}
		return ArrayUtils.EMPTY_OBJECT_ARRAY;
	}

}
