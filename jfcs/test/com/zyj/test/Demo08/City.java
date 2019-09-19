package com.zyj.test.Demo08;

import java.util.ArrayList;
import java.util.List;

public class City implements ITree{
    private Long id;
    private String name;
    private List<?> children = new ArrayList<Object>();
    public City(){
    }
    public City(String name){
        this.name = name;
    }
    public List<?> getChildren() {
        return children; 
    }
    public void setChildren(List<?> children) {
        this.children = children;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}