package com.zyj.test.databinding;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface PropertyChangeSupprot {
	/**
	 * 	留给子类实现
	 * @return
	 */
	public PropertyChangeSupport getPropertyChangeSupport();
	public default void addPropertyChangeListener(PropertyChangeListener
			listener) {
		getPropertyChangeSupport().addPropertyChangeListener(listener);
	}
    public default void removePropertyChangeListener(PropertyChangeListener
            listener) {
    	getPropertyChangeSupport().removePropertyChangeListener(listener);
    }
    public default void firePropertyChange(String propertyName, Object oldValue,
            Object newValue) {
    	getPropertyChangeSupport().firePropertyChange(propertyName, oldValue, newValue);
    }
}
