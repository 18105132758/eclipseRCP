package com.zyj.jfcs.app;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.zyj.jfcs.constants.AppConst;
/**
 * 透视图，设置界面布局， 需要实现接口IPerspectiveFactory，
 *  并在createInitialLayout方法中进行初始布局安排
 *
 */
public class Perspective implements IPerspectiveFactory {

	/**
	 * 创建初始布局，使用IPageLayout进行设置
	 */
	public void createInitialLayout(IPageLayout layout) {
		//获取透视图编辑区ID
		String editorArea = layout.getEditorArea();
		/*
		 * 隐藏编辑区: 编辑区用于容纳编辑器Editor，界面主要使用视图VIEW实现，因此应当将编辑区隐藏。
		 * 不过不影响编辑区的打开
		 */
		layout.setEditorAreaVisible(false);		
		//固定布局，既不能移动，也不能改变大小
		layout.setFixed(true);	
		
		/*
		 * 增加教学单位视图， 不能与其他视图重叠，因此使用addStandaloneView方法来增加
		 */
		layout.addStandaloneView(AppConst.VIEW_TEACH_UNIT_NAME_ID, 	//视图ID
				true, //展示标题
				IPageLayout.LEFT,	//布局在左侧 
				0.26F, 	//分割比例26%
				/*
				 *  指定被分隔空间的控件ID，会将指定元素目前占据的控件进行分割，应该是VIEW、folder、或者editor的id
				 *  左侧、上側的控件会占据分割比例指定的空间，右下占据剩余的空间
				 */
				editorArea);	//相关元素
		layout.getViewLayout(AppConst.VIEW_TEACH_UNIT_NAME_ID).setCloseable(false);	//禁用关闭功能
		layout.getViewLayout(AppConst.VIEW_TEACH_UNIT_NAME_ID).setMoveable(false);	//警用移动功能
		
		/*
		 *	加入经费概览视图，不能与其他视图重叠 
		 */
		layout.addStandaloneView(AppConst.VIEW_PIE_DIAGRAM_ID, true, IPageLayout.BOTTOM, 0.72F, AppConst.VIEW_TEACH_UNIT_NAME_ID);
		layout.getViewLayout(AppConst.VIEW_PIE_DIAGRAM_ID).setCloseable(false);
		layout.getViewLayout(AppConst.VIEW_PIE_DIAGRAM_ID).setMoveable(false);
		
		/*
		 * 加入课程明细视图，需要与其他视图重叠，因此使用addView方法添加
		 */
		layout.addView(AppConst.VIEW_TEACH_UNIT_CLASS__ID, IPageLayout.RIGHT, 0.76F, editorArea);
		layout.getViewLayout(AppConst.VIEW_TEACH_UNIT_CLASS__ID).setCloseable(false);
		layout.getViewLayout(AppConst.VIEW_TEACH_UNIT_CLASS__ID).setMoveable(false);
	}
}
