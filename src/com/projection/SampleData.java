package com.projection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.projection.pojo.Amount;
import com.projection.pojo.PurchaseItem;
import com.projection.pojo.ReportItem;

public class SampleData
{
//comment by dhinesh
	public static List<PurchaseItem> getData()
	{
		Calendar instance = Calendar.getInstance();
		Date todaysDate = new Date();
		List<Amount> futureAmounts = null;
		Amount amount = null;
		int i=0;
		PurchaseItem purchaseItem = null;
		List<PurchaseItem> myData = new ArrayList<PurchaseItem>();
		
		purchaseItem = new PurchaseItem();
		purchaseItem.setName("gold");
		purchaseItem.setPurchaseAmount(10000.0);
		instance.clear();
		instance.set(2000, Calendar.JANUARY, 1);
		purchaseItem.setPurchaseDate(instance.getTime());
		futureAmounts = new ArrayList<Amount>();
		amount = new Amount();
		amount.setDate(todaysDate);
		amount.setAmount(62773.0);
		futureAmounts.add(amount);
		purchaseItem.setFutureAmounts(futureAmounts);
		myData.add(purchaseItem );

		purchaseItem = new PurchaseItem();
		purchaseItem.setName("apartment");
		purchaseItem.setPurchaseAmount(4500000.0);
		instance.clear();
		instance.set(2004, Calendar.JANUARY, 1);
		purchaseItem.setPurchaseDate(instance.getTime());
		futureAmounts = new ArrayList<Amount>();
		amount = new Amount();
		amount.setDate(todaysDate);
		amount.setAmount(14000000.0);
		futureAmounts.add(amount);
		purchaseItem.setFutureAmounts(futureAmounts);
		myData.add(purchaseItem );

		return myData;

	}
}
