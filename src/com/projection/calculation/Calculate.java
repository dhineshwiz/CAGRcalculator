package com.projection.calculation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.projection.pojo.Amount;
import com.projection.pojo.PurchaseItem;
import com.projection.pojo.ReportItem;
import com.projection.report.HtmlGenerator;
import com.projection.util.ProjectionUtil;
import com.projection.util.ReportPurchaseDateComparator;

public class Calculate
{
	public static void getReport(List<PurchaseItem> purchaseItems)
	{
		List<ReportItem> reportItems = getReportItems(purchaseItems);
		Collections.sort(reportItems, new ReportPurchaseDateComparator());
		String html = HtmlGenerator.generateHtml(reportItems);
		writeToFile(html);
	}

	private static void writeToFile(String html)
	{
		 
		try
		{
			File file = new File("proj.html");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(html);
			bw.close();

			System.out.println("Done");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static List<ReportItem> getReportItems(List<PurchaseItem> purchaseItems)
	{
		Date finalDate = new Date();
		List<ReportItem> reportItemsList = new ArrayList<ReportItem>();
		for (PurchaseItem purchaseItem : purchaseItems)
		{
			Double finalAmount = getFinalAmount(purchaseItem,finalDate);
			Double purchaseAmount = purchaseItem.getPurchaseAmount();
			Double finalBankAmount = ProjectionUtil.getCompundedValue(purchaseItem, finalDate);
			Double diffAmount =  finalAmount - finalBankAmount;
			Double timeDiffInYears = ProjectionUtil.getTimeDiffInYears(purchaseItem.getPurchaseDate(),finalDate);
			
			ReportItem reportItem = new ReportItem();
			reportItem.setCagr(ProjectionUtil.getCAGR(purchaseAmount, finalAmount, timeDiffInYears));
			reportItem.setDiffAmount(diffAmount);
			reportItem.setFinalAmount(finalAmount);
			reportItem.setFinalBankAmount(finalBankAmount);
			reportItem.setFinalDate(finalDate);
			reportItem.setName(purchaseItem.getName());
			reportItem.setPurchaseAmount(purchaseItem.getPurchaseAmount());
			reportItem.setPurchaseDate(purchaseItem.getPurchaseDate());
			reportItem.setTimeDiff(timeDiffInYears);
			if(diffAmount <= 0.0){
				reportItem.setFinalValueColor(ProjectionUtil.RED);
			}else{
				reportItem.setFinalValueColor(ProjectionUtil.GREEN);
			}
			
			reportItemsList.add(reportItem);
		}
		return reportItemsList;
	}

	private static Double getFinalAmount(PurchaseItem purchaseItem, Date finalDate)
	{
		//TODO use finaldate
		Amount amount = purchaseItem.getFutureAmounts().get(0);
		return amount.getAmount();
	}
}
