package com.zyj.jfcs.app.service.yearTeachUnit;

import java.util.ArrayList;
import java.util.List;

import com.zyj.jfcs.app.model.YearTeachUnit;

public class YearTeachUnitService {
	
	public static YearTeachUnitService INSTANCE = new YearTeachUnitService();
	
	
	private YearTeachUnitService() {
		super();
	}

	public List<YearTeachUnit> getYearTeachUnitInYear(int year){
		List<YearTeachUnit> list = new ArrayList<YearTeachUnit>();
		
		YearTeachUnit ytn = new YearTeachUnit();
		ytn.setUnitName("汉语系");
		ytn.setUnitId("1");
		ytn.setHasggk("1");
		ytn.setHaszyk(null);
		list.add(ytn);
		
		ytn = new YearTeachUnit();
		ytn.setUnitName("理学系");
		ytn.setUnitId("2");
		ytn.setHasggk("1");
		ytn.setHaszyk("1");
		list.add(ytn);

		ytn = new YearTeachUnit();
		ytn.setUnitName("外语系");
		ytn.setUnitId("3");
		ytn.setHasggk("1");
		ytn.setHaszyk(null);
		list.add(ytn);
		ytn = new YearTeachUnit();
		ytn.setUnitName("哲学系");
		ytn.setUnitId("4");
		ytn.setHasggk(null);
		ytn.setHaszyk("1");
		list.add(ytn);
		
		return list;
	}
	
	
}
