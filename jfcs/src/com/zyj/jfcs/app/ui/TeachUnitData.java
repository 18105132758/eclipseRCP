package com.zyj.jfcs.app.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.ui.entity.teachUnitName.CurrYearPropertyChange;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;
import com.zyj.jfcs.constants.AppConst;
/**
 * 教学单位基本情况视图
 * 
 * @author zhouyj
 */
public class TeachUnitData extends ViewPart implements IPropertyChangeListener{
	
	
	private TableViewer tableViewer;
	
	/**
	 * 应收金额
	 */
	private Text jfys;
	/**
	 * 实收金额
	 */
	private Text jfss;
	/**
	 * 教授A人数
	 */
	private Text ta1;
	/**
	 * 教授B人数
	 */
	private Text ta2;
	/**
	 * 教授C人数
	 */
	private Text ta3;
	/**
	 * 教授D人数
	 */
	private Text ta4;
	/**
	 * 副教授A人数
	 */
	private Text ta5;
	/**
	 * 副教授B人数
	 */
	private Text ta6;
	/**
	 * 讲师人数
	 */
	private Text ta7;
	/**
	 * 助教人数
	 */
	private Text ta8;
	
	/**
	 * 年度教学单位对象
	 */
	private YearTeachUnit yearTeachUnit;
	
	/**
	 * 是否进入编辑状态
	 */
	private static boolean canEdit = false;
	/**
	 * 单位名称
	 */
	public static String UNIT_NAME = "unitname";
	/**
	 * 师生比
	 */
	public static String SSB = "ssb";
	/**
	 * 教学业务费比率
	 */
	public static String JXYWPER = "jxywper";
	/**
	 * 教学管理费比率
	 */
	public static String JXGLPER = "jxglper";
	/**
	 * 教学研究费比率
	 */
	public static String JXYJPER = "jxyjper";
	/**
	 * 师资培养费比率
	 */
	public static String SZPYPER = "szpyper";
	/**
	 * TableViewer的ColumnProperties属性，列的别名，用来对应实体类的属性
	 */
	public static final String[] PROPERtIES = {UNIT_NAME, SSB, JXYWPER, JXGLPER, JXYJPER, SZPYPER};
	
	private Action saveDataAction, editDataAction;
	
	private Group group;
	
	
	@Override
	public void createPartControl(Composite parent) {
		createContents(parent);
		
		createToolBar(parent);
		
		//注册属性监听器，在currYear改变时，刷新视图
		CurrYearPropertyChange.getInstance().addPropertyChangeListener(AppConst.VIEW_TEACH_UNIT_DATA_ID, this);
		
	}
	/**
	 * 	创建窗口主体内容
	 * @param parent
	 */
	private void createContents(Composite parent) {
		//设置标题
		setPartName(getConfigurationElement().getAttribute("name") + 
				"---" + YearManager.INSTANCE.getCurrYear() + "年");
		//容器，容纳主体内容
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		//创建TableViewer
		createTableViewer(container);
		//创建分组，显示基本数据文本框
//		createTextGroup(container);
	}
	
	private void createTableViewer(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.FULL_SELECTION);
		tableViewer.setUseHashlookup(true);
		
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		addTableColumn(table, "教学单位", 146, SWT.CENTER);
		addTableColumn(table, "师生比", 52, SWT.CENTER);
		addTableColumn(table, "教学业务费率", 90, SWT.CENTER);
		addTableColumn(table, "教学管理费率", 90, SWT.CENTER);
		addTableColumn(table, "教学研究费率", 90, SWT.CENTER);
		addTableColumn(table, "师资培养费率", 90, SWT.CENTER);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	private void addTableColumn(Table table, String columnName, int width, int style) {
		TableColumn column = new TableColumn(table, style);
		column.setText(columnName);
		column.setWidth(width);
	}
	
	private void createToolBar(Composite parent) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void dispose() {
		super.dispose();
		//销毁资源时，移除监听
		CurrYearPropertyChange.getInstance().removeListenerById(AppConst.VIEW_TEACH_UNIT_DATA_ID);
	}

	
}
