package com.projection.util;

import java.util.Comparator;

import com.projection.pojo.ReportItem;

public class ReportPurchaseDateComparator implements Comparator<ReportItem>
{

	@Override
	public int compare(ReportItem o1, ReportItem o2)
	{
		return o1.getPurchaseDate().compareTo(o2.getPurchaseDate());
	}

}
