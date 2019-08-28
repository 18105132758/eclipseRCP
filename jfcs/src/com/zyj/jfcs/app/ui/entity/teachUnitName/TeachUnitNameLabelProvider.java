package com.zyj.jfcs.app.ui.entity.teachUnitName;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.sys.CacheImage;
import com.zyj.jfcs.constants.ImagePath;

/**
 * 标签提供器
 * @author zhouyj
 *
 */
public class TeachUnitNameLabelProvider implements ITableLabelProvider{

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

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if(element instanceof YearTeachUnit) {
			YearTeachUnit yearTeachUnit = (YearTeachUnit) element;
			switch(columnIndex) {
			case 0:
				return CacheImage.getAppImage(ImagePath.TEACH_UNIT_NAME_ICO);
			case 1:
				String haszyk = yearTeachUnit.getHaszyk();
				return "1".equals(haszyk) ? CacheImage.getAppImage(ImagePath.TEACH_UNIT_ZYK_ICO) : null;
			case 2:
				String hasggk = yearTeachUnit.getHasggk();
				return "1".equals(hasggk) ? CacheImage.getAppImage(ImagePath.TEACH_UNIT_GGK_ICO) : null;
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof YearTeachUnit && columnIndex == 0) {
			return ((YearTeachUnit)element).getUnitName();
		}
		
			return null;
	}
	
	
}
