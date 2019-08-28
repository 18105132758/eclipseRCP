package com.zyj.jfcs.app.ui.entity.teachUnitName;

import java.util.Calendar;

public class YearManager {
	
	private int minYear;
	
	private int maxYear;
	
	
	private int currYear = Calendar.getInstance().get(Calendar.YEAR);
	
	public static final YearManager INSTANCE = new YearManager();


	private YearManager() {
		setMinMaxYear();
	}

	private void setMinMaxYear() {
		setMinYear(currYear - 5);
		setMaxYear(currYear);
	}
	
	public int getCurrYear() {
		return currYear;
	}

	public void setCurrYear(int currYear) {
		this.currYear = currYear;
	}

	public int getMinYear() {
		return minYear;
	}

	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	public int getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(int maxYear) {
		this.maxYear = maxYear;
	}
}
