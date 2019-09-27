package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Item;

import com.zyj.jfcs.app.ui.TeachUnitClass;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;
/**
 * 	单元格修正器
 * 	是将单元格的修改信息与数据实体进行同步
 * @author zhouyj
 *
 */
public class TeachUnitClassCellModifier implements ICellModifier {
	
	private TreeViewer treeViewer;
	
	public TeachUnitClassCellModifier(TreeViewer treeViewer) {
		super();
		this.treeViewer = treeViewer;
	}

	@Override
	public boolean canModify(Object element, String property) {
		if(element instanceof CourseTreeChildren) {
			if(TeachUnitClass.R1J.equals(property) || TeachUnitClass.R2J.equals(property) 
					|| TeachUnitClass.R2J.equals(property)) {
				return new SetControlEnabled().isEnabled(YearManager.INSTANCE.getCurrYear());
			}
		}
		return false;
	}
	
	/**
	 * 根据property获取java实例对象的数据，数据流向：java实例 -> SWT控件
	 */
	@Override
	public Object getValue(Object element, String property) {
		if(element instanceof CourseTreeChildren) {
			CourseTreeChildren ctc = (CourseTreeChildren) element;
			switch (property) {
			case TeachUnitClass.R1J:
				return ctc.getCourse().getR1j();
			case TeachUnitClass.R2J:
				return ctc.getCourse().getR2j();
			case TeachUnitClass.R3J:
				return ctc.getCourse().getR3j();
			}
		}
		return null;
	}

	/**
	 * 数据修正，前台修改数据时触发，数据流向： SWT控件-> java实例
	 */
	@Override
	public void modify(Object element, String property, Object value) {
		String vs = (String) value;
		if(StringUtils.isBlank(vs)) {
			value = null;
		}
		if(element instanceof Item) {
			element = ((Item)element).getData();
		}
		if(element instanceof CourseTreeChildren) {
			CourseTreeChildren ctc = (CourseTreeChildren) element;
			switch (property) {
			case TeachUnitClass.R1J:
				ctc.getCourse().setR1j(new BigDecimal((String)value));
				break;
			case TeachUnitClass.R2J:
				ctc.getCourse().setR2j(new BigDecimal((String)value));
				break;
			case TeachUnitClass.R3J:
				ctc.getCourse().setR3j(new BigDecimal((String)value));
				break;
			}
		}
		treeViewer.refresh();
	}

}
