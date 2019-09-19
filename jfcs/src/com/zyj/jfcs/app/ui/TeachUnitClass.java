package com.zyj.jfcs.app.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.zyj.jfcs.app.model.Course;
import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.CourseTreeChildren;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.CourseTreeParent;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.SetControlEnabled;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.SetTableColColorListener;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassCellModifier;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassContentProvider;
import com.zyj.jfcs.app.ui.entity.teachUnitClass.TeachUnitClassLabelProvider;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;
import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.AppShowInfo;
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
	public static final String[] COLUMN_PROPERTIES = 
		{COURSE_NAME, TERM, N2J, NJ, CLASS_NAME, R1J, R2J, R3J};
	
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
		c2.setText("学期");
		c2.setWidth(100);
		TreeColumn c3 = new TreeColumn(tree, SWT.RIGHT);	
		c3.setText("学时");
		c3.setWidth(100);
		TreeColumn c4 = new TreeColumn(tree, SWT.CENTER);	
		c4.setText("学生数");
		c4.setWidth(100);
		TreeColumn c5 = new TreeColumn(tree, SWT.CENTER);	
		c5.setText("班级");
		c5.setWidth(100);
		TreeColumn c6 = new TreeColumn(tree, SWT.CENTER);	
		c6.setText("层次");
		c6.setWidth(100);
		TreeColumn c7 = new TreeColumn(tree, SWT.CENTER);	
		c7.setText("课程/专业");
		c7.setWidth(100);
		TreeColumn c8 = new TreeColumn(tree, SWT.CENTER);	
		c8.setText("质量");
		c8.setWidth(100);
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
		
		YearTeachUnit ytu = new YearTeachUnit();
		ytu.setUnitName("测试");
		treeViewer.setInput(prepareData(ytu));
		
		
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
		
		calcAction = new Action("经费测算,",
				null
//				CacheImage.getImageDescriptor("")
				) {

			@Override
			public void run() {
				System.out.println("暂不实现.....");
			}
		};

		closeTreeAction = new Action("收缩数据", 
				null
//				CacheImage.getImageDescriptor("")
				) {

			@Override
			public void run() {
				treeViewer.collapseAll();
			}
			
		};
		
		openTreeAction = new Action("展开数据", 
				null
//				CacheImage.getImageDescriptor("")
				) {
			@Override
			public void run() {
				treeViewer.expandAll();
			}
		};
	}


	protected void saveData() {
		
		Iterator<?> data = ((List<?>)(treeViewer.getInput())).iterator();
		if(!data.hasNext()) {
			MessageDialog.openWarning(null, "提示", "没有课程明细数据！");
			return;
		}
		
		Job job = new Job("正在保存数据....") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("正在保存数据....", IProgressMonitor.UNKNOWN);
				while(data.hasNext()) {
					CourseTreeParent parent = (CourseTreeParent) data.next();
					Iterator<CourseTreeChildren> iterator = parent.getCourseTreeChildren().iterator();
					System.out.println(parent.getCourseName());
					while(iterator.hasNext()) {
						CourseTreeChildren child = iterator.next();
						monitor.worked(1);
						Course course = child.getCourse();
						System.out.println("\t" + course);
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				monitor.done();		//任务完成
				return Status.OK_STATUS;	//返回成功标志
			}
		};
		
		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				//获取任务处理结果状态
				boolean isSuccess = event.getResult().isOK();
				
				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						if(isSuccess) {
							MessageDialog.openInformation(null, "提示", "保存成功！");
						}else {
							MessageDialog.openInformation(null, "提示", "保存失败！");
						}
					}
				});
			}
		});
		job.setUser(false);	//不显示UI进度界面
		job.setPriority(Job.SHORT);		//设置较高优先级
		job.schedule();	//将当前job加入计划队列
		
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
		System.out.println("title:" + part.getTitle());
		
		if(selection.isEmpty()) {
			return;
		}
		
		saveAction.setEnabled(new SetControlEnabled().isEnabled(YearManager.INSTANCE.getCurrYear()));
		
		IViewPart vp = getViewSite().getPage().findView(AppConst.VIEW_TEACH_UNIT_NAME_ID);
		Table table = ((TeachUnitName)vp).getTableViewer().getTable();
		YearTeachUnit ytu = (YearTeachUnit) table.getItem(table.getSelectionIndex()).getData();
		
		treeViewer.setInput(prepareData(ytu));
	
		treeViewer.expandToLevel(2);	//展开2级
		
		System.out.println("待编写.....................");
	}
	
	
	public Object prepareData(YearTeachUnit ytu) {
		String unitName = "(" + ytu.getUnitName() + ")";
		List<CourseTreeParent> list = new ArrayList<CourseTreeParent>();
		//专业课
		CourseTreeParent ctp = new CourseTreeParent(AppShowInfo.TITLE_ZYKMX + unitName);
		list.add(ctp);
		CourseTreeChildren ctc = new CourseTreeChildren();
		ctc.setCourse(yw);
		ctp.add(ctc);
		ctc = new CourseTreeChildren();
		ctc.setCourse(sx);
		ctp.add(ctc);
		//公共课
		ctp = new CourseTreeParent(AppShowInfo.TITLE_GGKMX + unitName);
		list.add(ctp);
		ctc = new CourseTreeChildren();
		ctc.setCourse(yw);
		ctp.add(ctc);
		ctc = new CourseTreeChildren();
		ctc.setCourse(sx);
		ctp.add(ctc);
		System.out.println(list);
		return list;
	}
	
	private Course yw, sx;
	{
		yw = new Course();
		yw.setCourseName("语文");;
		yw.setTerm("1");
		yw.setN2j(50);
		yw.setNj(30);
		yw.setClassName("一一班");
		yw.setR1j(new BigDecimal(1));
		yw.setR2j(new BigDecimal(1));
		yw.setR3j(new BigDecimal(1));
		
		sx = new Course();
		sx.setCourseName("数学");;
		sx.setTerm("1");
		sx.setN2j(60);
		sx.setNj(20);
		sx.setClassName("一二班");
		sx.setR1j(new BigDecimal(1));
		sx.setR2j(new BigDecimal(1));
		sx.setR3j(new BigDecimal(1));
				
	}
}
