package com.zyj.test.Demo08;

import java.util.List;

public interface ITree {
	public String getName();
    public void setName(String name);
    public void setChildren(List<?> Children);
    public List<?> getChildren();
}
