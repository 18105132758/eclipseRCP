package com.zyj.jfcs.app.service.yearTeachUnit;

import java.util.ArrayList;
import java.util.List;

import com.zyj.jfcs.app.model.YearTeachUnit;
import com.zyj.jfcs.app.model.YearUnitJF;

public class YearTeachUnitService {
	
	public static YearTeachUnitService INSTANCE = new YearTeachUnitService();
	
	
	private YearTeachUnitService() {
		super();
	}

	public List<YearTeachUnit> getYearTeachUnitInYear(int year){
		List<YearTeachUnit> list = new ArrayList<YearTeachUnit>();
		
		YearTeachUnit ytn = new YearTeachUnit();
		ytn.setUnitName("汉语系" + year);
		ytn.setUnitId("1");
		ytn.setHasggk("1");
		ytn.setHaszyk(null);
		list.add(ytn);
		
		ytn = new YearTeachUnit();
		ytn.setUnitName("理学系" + year);
		ytn.setUnitId("2");
		ytn.setHasggk("1");
		ytn.setHaszyk("1");
		list.add(ytn);

		ytn = new YearTeachUnit();
		ytn.setUnitName("外语系" + year);
		ytn.setUnitId("3");
		ytn.setHasggk("1");
		ytn.setHaszyk(null);
		list.add(ytn);
		ytn = new YearTeachUnit();
		ytn.setUnitName("哲学系" + year);
		ytn.setUnitId("4");
		ytn.setHasggk(null);
		ytn.setHaszyk("1");
		list.add(ytn);
		
		return list;
	}
	
	/**
	 * 	获取某年度某单位的经费信息
	 * @param unitId
	 * @param year
	 * @return
	 */
	public YearUnitJF getYearUnitJF(String unitId, int year) {
		YearUnitJF yuj = new YearUnitJF();
		yuj.setUi(5 * year);
		yuj.setPi(1 * year);
		yuj.setCi(2 * year);
		yuj.setRyjf(3 * year);
		yuj.setZhywf(4 * year);
		
		return yuj;
	}
}
