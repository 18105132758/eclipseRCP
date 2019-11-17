package com.zyj.test.databinding;

import java.beans.PropertyChangeSupport;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.swt.widgets.Display;

public class Person implements PropertyChangeSupprot{
	private final PropertyChangeSupport changeSupport =
            new PropertyChangeSupport(this);

	private WritableValue<String> name = new WritableValue<String>(DisplayRealm.getRealm(Display.getCurrent()));
	public String getName() {
		return name.getValue();
	}
	public void setName(Object name) {
		String oldName = getName();
		this.name.setValue((String)name);
		firePropertyChange("name", oldName, name);
	}

	@Override
	public PropertyChangeSupport getPropertyChangeSupport() {
		return changeSupport;
	}
	
//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(Object name) {
//		String oldName = getName();
//		this.name = (String)name;
//		//通过这个方法通知UI控件，模型属性发生改变，请刷新前端数据
//		firePropertyChange("name", oldName, this.name);	
//	}
	
}
