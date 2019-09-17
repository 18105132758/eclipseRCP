package com.zyj.jfcs.app.ui.entity.teachUnitName;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.zyj.jfcs.constants.PropertyName;
/**
 * 当前年份改变监听控制器
 * @author zhouyj
 */
public class CurrYearPropertyChange {
	
	public static final CurrYearPropertyChange INSTANCE = new CurrYearPropertyChange();
	
	/**
	 * 已注册的监听器
	 */
	private static final Map<String, IPropertyChangeListener> registedListeners 
		= new HashMap<String, IPropertyChangeListener>();
	
	/**
	 * 激活属性改变监听
	 */
	public void firePropertyChangeListeners() {
		Iterator<IPropertyChangeListener> listeners = registedListeners.values().iterator();
		while(listeners.hasNext()) {
			listeners.next().propertyChange(
					new PropertyChangeEvent(this, PropertyName.CURR_YEAR, null, YearManager.INSTANCE.getCurrYear()));
		}
	}
	
	
	/**
	 * 注册监听器
	 */
	public void addPropertyChangeListener(String listenerId, IPropertyChangeListener listener) {
		if(!registedListeners.containsKey(listenerId)) {
			registedListeners.put(listenerId, listener);
		}
	}
	
	/**
	 * 移除监听	
	 * @param listenerId
	 */
	public void removeListenerById(String listenerId) {
		if(registedListeners.containsKey(listenerId)) {
			registedListeners.remove(listenerId);
		}
	}
	
	
	
	
}
