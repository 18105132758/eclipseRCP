package com.zyj.jfcs.app.ui;

import java.util.List;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.service.yearTeachUnit.YearTeachUnitService;
import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.app.ui.entity.teachUnitName.ControlContributionLabel;
import com.zyj.jfcs.app.ui.entity.teachUnitName.CurrYearPropertyChange;
import com.zyj.jfcs.app.ui.entity.teachUnitName.TeachUnitNameContentProvider;
import com.zyj.jfcs.app.ui.entity.teachUnitName.TeachUnitNameLabelProvider;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearCombo;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;
import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.PropertyName;

/**
 * 教学单位
 * @author 周昱君
 *
 */
public class TeachUnitName extends ViewPart implements IPropertyChangeListener{

	private TableViewer tableViewer;
	
	@Override
	public void createPartControl(Composite parent) {
		//创建单位信息表格
		createTableViewer(parent);
		//创建工具栏
		createToolBar(parent);
		
		//注册为监听器
		CurrYearPropertyChange.INSTANCE.addPropertyChangeListener(AppConst.VIEW_TEACH_UNIT_NAME_ID, this);
	}

	/**
	 * 创建工具栏
	 * @param parent
	 */
	private void createToolBar(Composite parent) {
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(new ControlContributionLabel("yearLabel", "年份："));
		toolBarManager.add(YearCombo.INSTANCE);
		
	}
	
	/**
	 * 创建单位信息表格
	 * @param parent
	 */
	private void createTableViewer(Composite parent) {
		//创建TableViewer
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL);
		tableViewer.setUseHashlookup(true);	//true：提高SWT元素与数据的映射效率
		
		//获取SWT  Table，并设置布局、背景
		final Table table = tableViewer.getTable();
		table.setBackgroundImage(CacheImage.getAppImage(null));
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		//添加教学单位、专业课、公共课 三列
		TableColumn unitNameColumn = new TableColumn(table, SWT.LEFT);
		unitNameColumn.setWidth(157);
		TableColumn hasZykColumn = new TableColumn(table, SWT.CENTER);
		hasZykColumn.setWidth(30);
		TableColumn hasGgkColumn = new TableColumn(table, SWT.CENTER);
		hasGgkColumn.setWidth(30);
		
		//注册内容提供器
		tableViewer.setContentProvider(new TeachUnitNameContentProvider());
		//注册标签提供器
		tableViewer.setLabelProvider(new TeachUnitNameLabelProvider());
		
		//填充表格数据源
		tableViewer.setInput(YearTeachUnitService.INSTANCE.getYearTeachUnitInYear(YearManager.INSTANCE.getCurrYear()));

		//选中第一条
		table.setSelection(0);
		table.setFocus();
		
		//注册为选中操作事件源
		getViewSite().setSelectionProvider(tableViewer);
	}
	
	
	
	@Override
	public void dispose() {
		super.dispose();
		//移除监听
		CurrYearPropertyChange.INSTANCE.removeListenerById(AppConst.VIEW_TEACH_UNIT_NAME_ID);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//事件处理
		if(PropertyName.CURR_YEAR.equals(event.getProperty())) {
			List<YearTeachUnit> list = YearTeachUnitService.INSTANCE.getYearTeachUnitInYear(YearManager.INSTANCE.getCurrYear());
			tableViewer.setInput(list);
			tableViewer.getTable().setSelection(0);
			tableViewer.getTable().setFocus();
		}
	}

}
