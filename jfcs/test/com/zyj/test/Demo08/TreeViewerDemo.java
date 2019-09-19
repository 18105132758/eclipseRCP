package com.zyj.test.Demo08;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class TreeViewerDemo {

    private static Tree tree;
    
	public static void main(String[] args) {
		
		 final Display display = Display.getDefault();
	        final Shell shell = new Shell();
	        shell.setSize(500, 375);
	        shell.setText("SWT Application");
	        //
	        final TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER|SWT.H_SCROLL);
	        tree = treeViewer.getTree();
	        tree.setBounds(83, 75, 264, 185);
	        
	        TreeColumn tc = new TreeColumn(tree, SWT.CENTER);
	        tc.setText("列1");
	        tc.setWidth(50);
	        tc = new TreeColumn(tree, SWT.CENTER);
	        tc.setText("列2");
	        tc.setWidth(80);
	        
	        treeViewer.setColumnProperties(new String[]{"C1", "C2"});
	        
	    	tree.setHeaderVisible(true);
			tree.setLinesVisible(true);
	        
	        
//	        treeViewer.setLabelProvider(new TreeLabelProvider());
//	        treeViewer.setContentProvider(new TreeContentProvider());
//	        treeViewer.setInput(Factory.createTree());
	        
	        shell.open();
	        shell.setLayout(new FillLayout());
	        shell.layout();
	        while (!shell.isDisposed()) {
	            if (!display.readAndDispatch())
	                display.sleep();
	        }

		
		
	}
	
	
 
}
