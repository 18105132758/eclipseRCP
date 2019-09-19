package com.zyj.test.Demo08;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TreeLabelProvider extends LabelProvider implements ILabelProvider {
    public String getText(Object element) {
        ITree node = (ITree)element;
        return node.getName();
    }
    public Image getImage(Object element) {
        return null;
    }
}