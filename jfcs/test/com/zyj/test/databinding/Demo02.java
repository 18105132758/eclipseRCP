package com.zyj.test.databinding;

import org.eclipse.core.runtime.Assert;

public class Demo02 {
	public static void main(String[] args) {
//		Assert.isNotNull(null, "Realm cannot be null"); //$NON-NLS-1$
		Assert.isNotNull("", "Realm cannot be null"); //$NON-NLS-1$
	}
}
