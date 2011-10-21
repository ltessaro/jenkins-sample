package com.jm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jm.vo.Magazine;

public class MagazineDAO {
	public Magazine[] listByPeriod(Date start, Date end) {
		List<Magazine> toReturn = new ArrayList<Magazine>();
		List<Magazine> all = EmulateData.getMagazines();
		for (Magazine m : all) {
			Date toCompare = m.getCreated();
			if (isValidPeriod(toCompare, start, end)) {
				toReturn.add(m);
			}
		}
		return toReturn.toArray(new Magazine[toReturn.size()]);
	}

	public Magazine getByDate(int month, int year) {
		List<Magazine> all = EmulateData.getMagazines();
		for (Magazine m : all) {
			Date toCompare = m.getCreated();
			
			if (toCompare.getMonth() == month && toCompare.getYear() == year) {
				return m;
			}
		}
		return null;
	}
	
	private boolean isValidPeriod(Date compare, Date start, Date end) {
		if (start == null && end != null)
			return end.after(compare);
		else if (start != null && end == null)
			return start.before(compare);
		else if (start == null && end == null)
			return false;
		else 
			return start.before(compare) && end.after(compare);
	}
}