package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.constants.AppShowInfo;
/**
 * 课程费用明细树 标签提供器
 * @author zhouyj
 *
 */
public class TeachUnitClassLabelProvider implements ITableLabelProvider {

	/**
	 * 返回当前单元格的图标，如果不设置图标，返回null就可以了
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		//如果是父节点
		if(element instanceof CourseTreeParent) {
			CourseTreeParent ctp = (CourseTreeParent) element;
			//设置专业课明细节点图标
			if(columnIndex == 0 && AppShowInfo.TITLE_ZYKMX.equals(ctp.getCourseName())) {
				return CacheImage.getAppImage("");
			}
			//设置公共课明细节点图标
			if(columnIndex == 0 && AppShowInfo.TITLE_GGKMX.equals(ctp.getCourseName())) {
				return CacheImage.getAppImage("");
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String text = "";
		//如果是父节点（一级节点）
		if(element instanceof CourseTreeParent) {
			CourseTreeParent ctp = (CourseTreeParent) element;
			text = columnIndex == 0 ? ctp.getCourseName() : "";
		}
		if(element instanceof CourseTreeChildren) {
			CourseTreeChildren ctc = (CourseTreeChildren) element;
			switch (columnIndex) {
			case 0:
				text = ctc.getCourse().getCourseName();		//课程名称
				break;
			case 1:
				text = ctc.getCourse().getTerm();		//学期
				break;
			case 2:
				text = ctc.getCourse().getN2j() + "";		//学时数
				break;
			case 3:
				text = ctc.getCourse().getNj() + "";		//学生数
				break;
			case 4:
				text = ctc.getCourse().getClassName();		//班级名称
				break;
			case 5:
				text = ctc.getCourse().getR1j() + "";		//学生层次系数
				break;
			case 6:
				text = ctc.getCourse().getR2j() + "";		// 课程/专业系数
				break;
			case 7:
				text = ctc.getCourse().getR3j() + "";		//课程质量系数
			}
		}
		return text.trim();
	}

	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}



}
