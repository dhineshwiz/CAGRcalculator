package com.projection.util;

import java.util.Date;

import com.projection.pojo.PurchaseItem;

public class ProjectionUtil
{
	public final static Double	BANK_RATE	= 7.2;
	public final static String	GREEN	= "GREEN";
	public final static String	RED	= "RED";
	

	public static Double getCompoundedValue(Double principal, Double rate, Double years)
	{
		if (principal != null && principal > 0 && rate != null && rate > 0 && years != null && years > 0)
		{
			rate = rate / 100.0;
			Double amount = principal * Math.pow(1 + rate, years);
			return amount;
		}
		return null;
	}

	public static Double getCAGR(Double beginValue, Double finalValue, Double years)
	{
		if (beginValue != null && beginValue > 0 && finalValue != null && finalValue > 0 && years != null && years > 0)
		{
			double temp = Math.pow((finalValue / beginValue), (1 / years));
			Double cagr = temp - 1.0;
			return cagr * 100.0;
		}
		return null;

	}

	public static Double getTimeDiffInYears(Date purchaseDate, Date finalDate)
	{
		double diff = Math.abs(purchaseDate.getTime() - finalDate.getTime());
		double diffyears = diff / (365.0 * 24 * 60 * 60 * 1000);
		return diffyears;
	}

	public static Double getCompundedValue(PurchaseItem purchaseItem, Date finalDate)
	{
		return getCompoundedValue(purchaseItem.getPurchaseAmount(), BANK_RATE, getTimeDiffInYears(purchaseItem.getPurchaseDate(), finalDate));
	}
}
