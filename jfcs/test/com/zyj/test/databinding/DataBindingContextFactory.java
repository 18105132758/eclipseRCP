package com.zyj.test.databinding;

import org.eclipse.core.databinding.observable.sideeffect.ISideEffectFactory;
import org.eclipse.jface.databinding.swt.WidgetSideEffects;
import org.eclipse.swt.widgets.Control;

public class DataBindingContextFactory {
		
	
	
	public static ISideEffectFactory create(Control control) {
		ISideEffectFactory sideEffectFactory = WidgetSideEffects.createFactory(control);
		return sideEffectFactory;
	}
//	public static DataBindingContext create() {
//		DataBindingContext context = new DataBindingContext();
		//添加觀察者工廠
//		context.add
//	}
	
}
