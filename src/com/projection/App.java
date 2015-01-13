package com.projection;

import java.util.ArrayList;
import java.util.List;

import com.projection.calculation.Calculate;
import com.projection.pojo.PurchaseItem;

public class App
{
	public static void main(String[] args)
	{
//		List<PurchaseItem> purchaseItems = HomeData.getData();
		List<PurchaseItem> purchaseItems = SampleData.getData();
		Calculate.getReport(purchaseItems);
	}

}
