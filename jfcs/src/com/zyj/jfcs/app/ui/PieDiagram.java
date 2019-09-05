package com.zyj.jfcs.app.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.model.YearUnitJF;
import com.zyj.jfcs.app.service.yearTeachUnit.YearTeachUnitService;
import com.zyj.jfcs.app.ui.entity.teachUnitName.YearManager;
import com.zyj.jfcs.constants.AppConst;
import com.zyj.jfcs.constants.PropertyName;
/**
 * 经费概览视图, 需要监听年度、 教学单位的变化，实时刷新视图数据
 * @author 周昱君
 *
 */
public class PieDiagram extends ViewPart implements 
	ISelectionListener, 
	IPropertyChangeListener{

	/**
	 * 饼图文字严肃
	 */
	private Color textColor;
	/**
	 * 饼图背景色
	 */
	private Color bgColor;
	/**
	 * 学生经费图例颜色
	 */
	private Color uibgColor;
	/**
	 * 专业培养费图例颜色
	 */
	private Color pibgColor;
	/**
	 * 公共课经费图例颜色
	 */
	private Color cibgColor;
	/**
	 * 	奖酬金经费图例颜色
	 */
	private Color jcjbgColor;
	/**
	 * 	综合业务费图例颜色
	 */
	private Color zhywbgColor;
	/**
	 * 	画板颜色
	 */
	private Color canvasbgColor;
	
	
	/**
	 * 字体
	 */
	private Font font;
	
	/**
	 * 画板
	 */
	private Canvas canvas;
	
	public PieDiagram() {
		init();
	}

	private void init(){
		Display display = Display.getCurrent();
		textColor = display.getSystemColor(SWT.COLOR_WHITE);
		bgColor = display.getSystemColor(SWT.COLOR_BLUE);
		uibgColor = display.getSystemColor(SWT.COLOR_GREEN);
		pibgColor = display.getSystemColor(SWT.COLOR_YELLOW);
		cibgColor = display.getSystemColor(SWT.COLOR_RED);
		jcjbgColor = display.getSystemColor(SWT.COLOR_GRAY);
		zhywbgColor = display.getSystemColor(SWT.COLOR_CYAN);
		canvasbgColor = display.getSystemColor(SWT.COLOR_BLACK);
		font = new Font(display, "楷体", 9, SWT.NONE);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		YearTeachUnit ytu = getSelectedUnit();
		
		//设置视图标题
		setPartName(
				getConfigurationElement().getAttribute("name") //获取plugin.xml中为本视图配置的name属性值
				+ ytu.getUnitName());
		
		canvas = new Canvas(parent, SWT.NONE);
		canvas.setBackground(canvasbgColor);
		
		drawDiagram(parent, YearManager.INSTANCE.getCurrYear(), ytu.getUnitId());
		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addSelectionListener(this);
	}

	int i = 0;
	List<PaintListener> paintListeners = new ArrayList<PaintListener>();
	private void drawDiagram(Composite parent, int year, String unitId) {
		if(!paintListeners.isEmpty()) {
			for (PaintListener paintListener : paintListeners) {
				canvas.removePaintListener(paintListener);
			}
			paintListeners.clear();
		}
		
		System.out.println("画图 " + (i++) + "次");
//		PaintListener listener = new PaintListener() {
//			@Override
//			public void paintControl(PaintEvent e) {
//				System.out.println("画图1 " + (i++) + "次");
////				e.gc.setBackground(canvasbgColor);
////				e.gc.fillRectangle(0, 0, ((Canvas)e.widget).getBounds().width, 
////						((Canvas)e.widget).getBounds().width);	//清空之前的内容？？否则重画时会导致页面残留
//			}
//		};
//		canvas.addPaintListener(listener);
//		paintListeners.add(listener);
//		canvas.redraw();
		
		YearUnitJF jf = YearTeachUnitService.INSTANCE.getYearUnitJF(unitId, year);

		double ui = jf.getUi();
		double pi = jf.getPi();
		double ci = jf.getCi();
		double ryjf = jf.getRyjf();
		double zhywf = jf.getZhywf();
		double total = jf.getTotal();
		if(total == 0) {
			canvas.addPaintListener(new DrawArc(0, 0, 0, 360, -1, textColor, 0, 0, 0, 0, 0));
			return;
		}
		int uiPer = (int) (jf.getPer(ui) * 360);
		int piPer = (int) (jf.getPer(pi) * 360);
		int ciPer = (int) (jf.getPer(ci) * 360);
		int ryjfPer = (int) (jf.getPer(ryjf) * 360);
		int zhywfPer = (int) (jf.getPer(zhywf) * 360);
		//绘制各类经费
		PaintListener listener = new DrawArc(0, 0, 0, uiPer, 1, uibgColor, ui, pi, ci, ryjf, zhywf);
		canvas.addPaintListener(listener);
		paintListeners.add(listener);
		
		listener = new DrawArc(0, 0, uiPer, piPer, 2, pibgColor, ui, pi, ci, ryjf, zhywf);
		canvas.addPaintListener(listener);
		paintListeners.add(listener);
//		
		listener = new DrawArc(0, 0, uiPer + piPer, ciPer, 3, cibgColor, ui, pi, ci, ryjf, zhywf);
		canvas.addPaintListener(listener);
		paintListeners.add(listener);
//		
		listener = new DrawArc(0, 0, uiPer + piPer + ciPer, ryjfPer, 4, jcjbgColor, ui, pi, ci, ryjf, zhywf);
		canvas.addPaintListener(listener);
		paintListeners.add(listener);
//		
//		listener = new DrawArc(0, 0, uiPer + piPer + ciPer + ryjfPer, zhywfPer, 5, zhywbgColor, ui, pi, ci, ryjf, zhywf);
//		canvas.addPaintListener(listener);
//		paintListeners.add(listener);
		
//		listener = new PaintListener() {
//			@Override
//			public void paintControl(PaintEvent e) {
//				System.out.println("画图2 " + (i++) + "次");
//			}
//		};
//		canvas.addPaintListener(listener);
//		paintListeners.add(listener);
		
	}
	
	
	@Override
	public void dispose() {
		textColor.dispose();
		bgColor.dispose();
		uibgColor.dispose();
		pibgColor.dispose();
		cibgColor.dispose();
		jcjbgColor.dispose();
		zhywbgColor.dispose();
		canvasbgColor.dispose();
		font.dispose();
		
		super.dispose();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		if(PropertyName.CURR_YEAR.equals(event.getProperty())) {
			refereshView();
		}
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		if(selection != null) {
			refereshView();
		}
		
	}
	
	private void refereshView() {
		System.out.println("刷新视图.......");
		YearTeachUnit ytu = getSelectedUnit();
		
		//设置标题栏问你
		setPartName(getConfigurationElement().getAttribute("name")
				+ "---" + ytu.getUnitName());
		
		drawDiagram(getViewSite().getShell(), YearManager.INSTANCE.getCurrYear(), ytu.getUnitName());
	}
	
	

	/**
	 * 获取选中数据
	 * @return
	 */
	private YearTeachUnit getSelectedUnit() {
		Table table = getTable();
		return (YearTeachUnit) table.getItem(table.getSelectionIndex()).getData();
	}
	
	private Table getTable() {
		TeachUnitName vp =  (TeachUnitName) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getActivePage().findView(AppConst.VIEW_TEACH_UNIT_NAME_ID);
		return vp.getTableViewer().getTable();
	}
	
	
	/**
	 * 画弧度
	 * @author zhouyj
	 *
	 */
	private class DrawArc implements PaintListener{

		private int x, y, beginAngle, angle, tag;
		
		private Color color;
		
		private double ui, pi, ci, ryjf, zhywf;
		
		
		
		
		public DrawArc(int x, int y, int beginAngle, int angle, int tag, Color color, 
				double ui, double pi, double ci, double ryjf, double zhywf) {
			super();
			this.x = x;
			this.y = y;
			this.beginAngle = beginAngle;
			this.angle = angle;
			this.tag = tag;
			this.color = color;
			this.ui = ui;
			this.pi = pi;
			this.ci = ci;
			this.ryjf = ryjf;
			this.zhywf = zhywf;
		}




		@Override
		public void paintControl(PaintEvent e) {
			System.out.println("画图 " + (i++) + "次");
			Canvas canvas = (Canvas) e.widget;
			int x = canvas.getBounds().width;
			int y = canvas.getBounds().height;
			
//			canvas.setBackground(color);	//导致反复刷新界面？？？？？
			e.gc.setBackground(color);	
			
			//画图
			e.gc.fillArc(this.x + 15, this.y + 1, x - 30, y - 60, beginAngle, angle);
			e.gc.setFont(font);
			
			switch(tag) {
			case -1:
				e.gc.setForeground(textColor);
				e.gc.drawString("各部分经费均为0！", 1, y - 40, true);
				break;
			case 1:
				e.gc.setForeground(textColor);
				e.gc.drawString("单位：万元",  x / 4, y - 50, true);
				e.gc.setForeground(color);
				e.gc.drawString("□", 0, y - 38, true);
				e.gc.setForeground(textColor);
				e.gc.drawString("学生经费" + ui,  12, y - 38, true);
				break;
			case 2:
				e.gc.setForeground(color);
				e.gc.drawString("□", 102, y - 38, true);
				e.gc.setForeground(textColor);
				e.gc.drawString("公共课" + pi,  113, y - 38, true);
				break;
			case 3:
				e.gc.setForeground(color);
				e.gc.drawString("□", 0, y - 26, true);
				e.gc.setForeground(textColor);
				e.gc.drawString("专业培养" + ci,  12, y - 26, true);
				break;
			case 4:
				e.gc.setForeground(color);
				e.gc.drawString("□", 102, y - 26, true);
				e.gc.setForeground(textColor);
				e.gc.drawString("人员经费" + ryjf,  113, y - 26, true);
				break;
			case 5:
				e.gc.setForeground(color);
				e.gc.drawString("□", 0, y - 14, true);
				e.gc.setForeground(textColor);
				e.gc.drawString("综合业务" + zhywf,  12, y - 14, true);
				break;
			}
		}

	}

}
