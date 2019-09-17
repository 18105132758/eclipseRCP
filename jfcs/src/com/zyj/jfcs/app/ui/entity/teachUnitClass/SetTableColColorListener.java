package com.zyj.jfcs.app.ui.entity.teachUnitClass;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
/**
 * 用于树、表格当前记录改变时，将当前行以颜色渐变的方式凸显出来
 * @author zhouyj
 *
 */
public class SetTableColColorListener implements Listener {

	private Table table = null;
	
	private Tree tree = null;
	
	
	
	public SetTableColColorListener(Tree tree) {
		super();
		this.tree = tree;
	}

	public SetTableColColorListener(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void handleEvent(Event event) {
		if((event.detail & SWT.SELECTED) != 0) {
			GC gc = event.gc;
			Rectangle area = getClientArea();
			Rectangle rect = event.getBounds();
			//设置前景色、背景色
			Color foreColor = new Color(Display.getCurrent(), 0x8c, 0xb3, 0xe1);
			gc.setForeground(foreColor);
			gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			//设置颜色渐变效果， true表示纵向渐变，如果设置为false，则横向渐变
			gc.fillGradientRectangle(0, rect.y - 3, area.width, rect.height, true);
			//通过改变event.detail来指定操作行为，否则上述操作不生效
			event.detail &= ~SWT.SELECTED;
			//销毁资源
			foreColor.dispose();
			gc.dispose();
		}
	}
	
	private Rectangle getClientArea() {
		if(tree != null) {
			return tree.getClientArea();
		}
		
		if(table != null) {
			return table.getClientArea();
		}
		return null;
	}
}
