package com.zyj.jfcs.app.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.SetTableColColorListener;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassCellModifier;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassContentProvider;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassLabelProvider;
import com.zyj.jfcs.constants.ImagePath;
/**
 * 教学单位课程明细
 * @author 周昱君
 *
 */
public class TeachUnitClass extends ViewPart implements ISelectionListener{
	/**
	 * 课程名称
	 */
	public static final String COURSE_NAME = "courseName";
	/**
	 * 学期
	 */
	public static final String TERM = "term";
	/**
	 * 学时数
	 */
	public static final String N2J = "n2j";
	/**
	 * 学生数
	 */
	public static final String NJ = "nj";
	/**
	 * 班级名
	 */
	public static final String CLASS_NAME = "className";
	/**
	 * 学生层次系数
	 */
	public static final String R1J = "r1j";
	/**
	 * 课程或者专业系数
	 */
	public static final String R2J = "r2j";
	/**
	 * 课程质量系数
	 */
	public static final String R3J  = "r3j";
	/**
	 * 列属性，用来映射 控件数据-实体属性
	 */
	public static final String[] COLUMN_PROPERTIES = {COURSE_NAME, TERM, N2J, NJ, CLASS_NAME, R1J, R2J, R3J};
	
	/**
	 * 树表格
	 */
	private TreeViewer treeViewer;

	/**
	 * 工具栏按钮：保存、计算经费、收起、展开
	 */
	private Action saveAction, calcAction, closeTreeAction, openTreeAction;
	
	

	
	public TeachUnitClass() {
		super();
	}


	@Override
	public void createPartControl(Composite parent) {
		createTreeViewer(parent);

		createActions();
		
		createToolbarButtons();
		//监听视图TeachUnitName的SelectProvider（年份列表），以便其发生改变时激活当前类（ISelectionListener）
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addSelectionListener(this);
	}

	private void createTreeViewer(Composite parent) {
		//样式： 有边框、支持滚动、点击时选中当前行
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION);
		//使用hash表加速 元素与SWT控件 之间的映射
		treeViewer.setUseHashlookup(true);
		
		//内容提供器
		treeViewer.setContentProvider(new TeachUnitClassContentProvider());
		//标签提供器
		treeViewer.setLabelProvider(new TeachUnitClassLabelProvider());
		
		//创建表头列
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		TreeColumn c1 = new TreeColumn(tree, SWT.LEFT);	//内容居左显示： CENTER-居中，RIGHT-居右
		c1.setText("课程名称");
		c1.setWidth(175);
		TreeColumn c2 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("学期");
		c1.setWidth(40);
		TreeColumn c3 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("学时");
		c1.setWidth(40);
		TreeColumn c4 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("学生数");
		c1.setWidth(52);
		TreeColumn c5 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("班级");
		c1.setWidth(112);
		TreeColumn c6 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("层次");
		c1.setWidth(62);
		TreeColumn c7 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("课程/专业");
		c1.setWidth(70);
		TreeColumn c8 = new TreeColumn(tree, SWT.CENTER);	
		c1.setText("质量");
		c1.setWidth(40);
		treeViewer.setColumnProperties(COLUMN_PROPERTIES);
		/*
		 * 创建编辑器，前5列为null，表示不能修改，
		 * 层次系数、课程/专业系数、质量系数  可以编辑，使用TextCellEditor
		 */
		CellEditor[] editors = new CellEditor[8];
		editors[5] = new TextCellEditor(tree);
		editors[6] = new TextCellEditor(tree);
		editors[7] = new TextCellEditor(tree);
		treeViewer.setCellEditors(editors);
		//设置TreeViewer的CellModifier：主要负责将修改数据与实体数据进行同步
		treeViewer.setCellModifier(new TeachUnitClassCellModifier(treeViewer));
		
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		treeViewer.expandToLevel(2);	//默认展开2级
		tree.setFocus();
		//突出显示当前选中行
		tree.addListener(SWT.EraseItem, new SetTableColColorListener(tree));
		
	}

	/**
	 * 创建Action
	 */
	private void createActions() {
		saveAction = new Action("数据保存", CacheImage.getImageDescriptor(ImagePath.PUBLIC_SAVE_ICO)) {

			@Override
			public void run() {
				saveData();
			}
			
		};
		
		calcAction = new Action("经费测算,", CacheImage.getImageDescriptor("")) {

			@Override
			public void run() {
				System.out.println("暂不实现.....");
			}
		};

		closeTreeAction = new Action("收缩数据", CacheImage.getImageDescriptor("")) {

			@Override
			public void run() {
				treeViewer.collapseAll();
			}
			
		};
		
		openTreeAction = new Action("展开数据", CacheImage.getImageDescriptor("")) {
			@Override
			public void run() {
				treeViewer.expandAll();
			}
		};
	}


	protected void saveData() {
		// TODO Auto-generated method stub
		System.out.println("保存数据.....");
	}

	/**
	 * 创建工具栏按钮
	 */
	private void createToolbarButtons() {
		IToolBarManager toolBar = getViewSite().getActionBars().getToolBarManager();
		
		toolBar.add(saveAction);
		toolBar.add(calcAction);
		toolBar.add(closeTreeAction);
		toolBar.add(openTreeAction);
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	/**
	 * 监听教学单位视图： 教学单位选择、 年份选择的状态变化
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println("待编写.....................");
	}

}
